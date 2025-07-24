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