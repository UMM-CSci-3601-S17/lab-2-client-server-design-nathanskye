// Just some example testing.

//describe('testing basic functions', function(){
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
//});

describe('Testing ID lookup', function(){

    it('URL should be generated with correct with ID', function(){
        expect(retrieve("58895985a22c04e761776d54")).toEqual("/api/todos/58895985a22c04e761776d54")
    });

    it('URL should be generated with correct with ID', function(){
            expect(retrieve("5889598576fb09f2f42da378")).toEqual("/api/todos/5889598576fb09f2f42da378")
    });

});

