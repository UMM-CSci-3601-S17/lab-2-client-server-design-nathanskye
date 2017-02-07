window.onload = function() {
    console.log("The page is loaded now!");

    var filterElement = document.getElementById('filter');
    filterElement.addEventListener("click", filterHandler, true);

    var retrieveElement = document.getElementById('retrieve');
    retrieveElement.addEventListener("click", retrieveHandler, true);
}

// Wrapper for ID retrievals
// Makes testing with Karma easier
function retrieveHandler(){
    var request = retrieve(document.getElementById("id").value);
    if(request != "/api/todos/")
        sendHTTPRequest(request);
}

function filterHandler(){

    var request = filter( document.getElementById("owner").value,
                          document.getElementById("keyword").value,
                          document.getElementById("category").value,
                          document.getElementById("limit").value,
                          document.getElementById("status").value,
                          document.querySelector('input[name = "sortGroup"]:checked').value
                           );

    if(request != "/api/todos/")
        sendHTTPRequest(request);
}

function sendHTTPRequest(request){
    var HttpThingy = new HttpClient();
    HttpThingy.get(request, function(returned_json){
        document.getElementById('jsonOutput').innerHTML = returned_json;
    });
}

// Retrieves and returns a todo by an id number
var retrieve = function(id) {

    var request = "/api/todos/";

    if(id != "")
        request = request.concat(id);

    return request;
}

// Retrieve todos by filtering between owner, status, keyword, category and limit
var filter = function(owner, keyword, category, limit, status, orderBy) {

    var request = "/api/todos?";

    if( owner != "")
        request = request.concat("owner=" + owner + "&");

    if( keyword != "")
        request = request.concat("contains=" + keyword + "&");

    if( category != "")
        request = request.concat("category=" + category + "&");

    if( limit != "")
        request = request.concat("limit=" + limit + "&");

    if( status != "")
        request = request.concat("status=" + status + "&");

    if( orderBy != "")
        request = request.concat("orderBy=" + orderBy + "&");

    return request;
}



/**
 * Wrapper to make generating http requests easier. Should maybe be moved
 * somewhere else in the future!.
 *
 * Based on: http://stackoverflow.com/a/22076667
 * Now with more comments!
 */
function HttpClient() {
    // We'll take a URL string, and a callback function.
    this.get = function(aUrl, aCallback){
        var anHttpRequest = new XMLHttpRequest();

        // Set a callback to be called when the ready state of our request changes.
        anHttpRequest.onreadystatechange = function(){

            /**
             * Only call our 'aCallback' function if the ready state is 'DONE' and
             * the request status is 200 ('OK')
             *
             * See https://httpstatuses.com/ for HTTP status codes
             * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
             *  for XMLHttpRequest ready state documentation.
             *
             */
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
        }

        anHttpRequest.open("GET", aUrl, true);
        anHttpRequest.send(null);
    }
}