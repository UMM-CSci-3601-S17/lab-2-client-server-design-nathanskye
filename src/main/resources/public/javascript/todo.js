window.onload = function() {
    console.log("The page is loaded now!");

    var element = document.getElementById('search');
    element.addEventListener("click", search, true);
}

var search = function() {
    // var HttpThingy = new HttpClient();
    // HttpThingy.get("/api/users", function(returned_json){
    //     document.getElementById('jsonDump').innerHTML = returned_json;
    // });
    //document.getElementById("jsonOutput").innerHTML = document.getElementById("id").value;

    var request = "";
    var temp;

    if( (temp = document.getElementById("id").value) != "")
        request = request.concat(temp);

    if( (temp = document.getElementById("owner").value) != "")
        request = request.concat(temp);

    if( (temp = document.getElementById("status").value) != "")
        request = request.concat(temp);

    if( (temp = document.getElementById("keyword").value) != "")
        request = request.concat(temp);

    if( (temp = document.getElementById("category").value) != "")
        request = request.concat(temp);

    document.getElementById("jsonOutput").innerHTML = request;

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