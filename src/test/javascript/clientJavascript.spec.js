describe('Testing ID lookup', function(){

    it('URL should be generated with correct with ID', function(){
        expect(retrieve("58895985a22c04e761776d54")).toEqual("/api/todos/58895985a22c04e761776d54")
    });

    it('URL should be generated with correct with ID', function(){
            expect(retrieve("5889598576fb09f2f42da378")).toEqual("/api/todos/5889598576fb09f2f42da378")
    });

});

describe('Testing Filter by many parameters', function(){



});