// CONCEPT 1 : Initialized with undefined 
var carName; // undefined
carName = "Ford";

var carName2 = "Volvo";



// CONCEPT 2 : If you re-declare a JavaScript variable, it will not lose its value.
var carName = "Volvo";
var carName;

var x = "John Doe";
var x = 0; // can be redeclared




// CONCEPT 3 : If you put a number in quotes, the rest of the numbers will be treated as strings, and concatenated.
var x = 2 + 3 + "5";




//  CONCEPT 4 : var keyword can NOT have block scope
{
    var x = 2;
}
// x CAN be used here





// CONCEPT 5 : Redeclaring a variable inside a block will also redeclare the variable outside the block
var x = 10;
// Here x is 10
{
var x = 2;
// Here x is 2
}
// Here x is 2




// CONCEPT 6 : Variables defined with let cannot be Redeclared 
let x = "John Doe";
let x = 0; // error





// CONCEPT 7 : Variables defined with let must be Declared before use
{
    let x = 2;
} 
// x can NOT be used here





// CONCEPT 8 : Redeclaring a variable inside a block will not redeclare the variable outside the block
let x = 10;
// Here x is 10
{
let x = 2;
// Here x is 2
}

// Here x is 10






// CONCEPT 9 : With let, redeclaring a variable in the same block is NOT allowed:
var x = 2;    // Allowed
let x = 3;    // Not allowed

{
let x = 2;    // Allowed
let x = 3     // Not allowed
}

{
let x = 2;    // Allowed
var x = 3     // Not allowed
}




// CONCEPT 10 : Redeclaring a variable with let, in another block, IS allowed

let x = 2;    // Allowed

{
let x = 3;    // Allowed
}

{
let x = 4;    // Allowed
}


// CONCEPT 11 : Variables defined with const cannot be Redeclared.
const PI = 3.141592653589793;
PI = 3.14;      //  error


// CONCEPT 12 : JavaScript const variables must be assigned a value when they are declared
const PI; // error
PI = 3.14159265359;




