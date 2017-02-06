// Just some example testing.

describe('testing basic functions', function(){
    // it('should return the correct string length', function(){
    //     expect(testStringLength("kittens")).toEqual(7);
    // });
    //
    // it('returnKittens should return kittens', function(){
    //
    //      var result = document.getElementById("jsonOutput").innerHTML;
    //  });
    //
    //this test should fail.
    // it('this test should fail!', function(){
    //     expect(returnKittens()).toBe("kittens");
    // });
});

describe('Testing ID lookup', function(){


    it('URL should be correct with ID', function(){

        document.getElementById("id").value = "58895985a22c04e761776d54";

        var result = retrieve();

        var jsonOutput = document.getElementById("jsonOutput").value;

        expect(jsonOutput.length).toEqual(229);

    });

});

