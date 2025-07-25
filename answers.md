## Chapter 5: Representing Code

### 1
```text
expr → expr ( "(" ( expr ( "," expr )* )? ")" | "." IDENTIFIER )+
     | IDENTIFIER
     | NUMBER
```

could be rewritten as

```text
expr → expr ("(" ( expr ( "," expr )* )? ")")+

append_arg -> "," expr
append_many_args -> ""
append_many_args -> append_arg append_many_args
arg_list → ""
arg_list → expr
arg_list -> expr append_many_args
apply_args -> "(" arg_list ")"

access_attribute → "." IDENTIFIER
maybe_access_attribute -> ""
maybe_access_attribute -> access_attribute
many_access_attribute -> ""
many_access_attribute -> access_attribute many_access_attribute
expr → expr access_attribute many_access_attribute

expr → expr

expr → IDENTIFIER

expr → NUMBER
```

This bit of grammar encode 3 kind of expression:
- accessing an attribute of an object or,
- an identifier or,
- a number

### 2

```hs
data Expr = Binary Expr Token Expr | Grouping Expr | Unary Token Expr | Literal String

prettyPrint :: Expr -> String
prettyPrint (Binary left op right) = undefined
prettyPrint (Grouping expr) = undefined
prettyPrint (Unary op expr) = undefined
prettyPrint (Literal val) = undefined
```

### 3

See `RPNPrinter.java`

## Chapter 6: Parsing Expressions

### 1
The grammar becomes

```
expression -> comma ;
comma -> equality ("," equality)*; 
equality -> comparison ( ( "!=" | "==" ) comparison )* ;
# ... the rest of the grammar does not changes
```

### 2

The grammer evolves to

```
expression -> ternary ;
ternary -> comma ("?" comma ":" comma )? ;
comma -> equality ("," equality)*; 
equality -> comparison ( ( "!=" | "==" ) comparison )* ;
# ... the rest of the grammar does not changes
```

### 3
TODO

## Chapter 7: Evaluating Expressions
## 1
TODO

## 2
TODO

## 3
Even if Node.js return infinity when dividing by zero, it's mathematically invalid so a runtime error seems more adequate.

## Chapter 8: Statements and State
## 1
It would involve tweaking the parser to allow expression as valid jlox source code.
For the implementation, I chose to add a boolean flag to the parser to indicate if it's on REPL mode or not.

## 2
It would involve defining a special value for unitialized variables to differentiate them from variables initialized with null or assigned with null.

## 3
TODO

## Chapter 9: Control Flow
### 1
With first-class functions we could define an `if` function.

### 2
We could use recursion.
We could use tail call optimization.

### 3
An implementation for the interpreter could use an exception when encountering a break.

## Chapter 10: Functions
### 1
TODO

### 2
TODO

### 3
TODO

## Chapter 11: Resolving and Binding
### 1
(I'm not sure about this answer ...)

Using unitialized variable can lead to unexpected behavior of the program, since the variable may contain some value that is not wanted by the user.

### 2
TODO

### 3
TODO

### 4
TODO

