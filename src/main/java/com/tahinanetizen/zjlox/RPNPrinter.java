package com.tahinanetizen.zjlox;

import com.tahinanetizen.zjlox.Expr.Assign;
import com.tahinanetizen.zjlox.Expr.Binary;
import com.tahinanetizen.zjlox.Expr.Call;
import com.tahinanetizen.zjlox.Expr.Grouping;
import com.tahinanetizen.zjlox.Expr.Literal;
import com.tahinanetizen.zjlox.Expr.Logical;
import com.tahinanetizen.zjlox.Expr.Unary;
import com.tahinanetizen.zjlox.Expr.Variable;

public class RPNPrinter implements Expr.Visitor<String> {

    public static void main(String[] args) {
        Expr expr = new Expr.Binary(
            new Expr.Grouping(new Expr.Binary(new Expr.Literal(1), new Token(TokenType.PLUS, "+", null, 1), new Expr.Literal(2))), 
            new Token(TokenType.STAR, "*", null, 1), 
            new Expr.Grouping(new Expr.Binary(new Expr.Literal(4), new Token(TokenType.MINUS, "-", null, 1), new Expr.Literal(3)))
            );

        System.out.println(expr.accept(new RPNPrinter()));
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return expr.left.accept(this) + " " + expr.right.accept(this) + " " + expr.operator.lexeme;
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
       return expr.expression.accept(this);
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return expr.right.accept(this);
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitAssignExpr'");
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitVariableExpr'");
    }

    @Override
    public String visitLogicalExpr(Logical expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitLogicalExpr'");
    }

    @Override
    public String visitCallExpr(Call expr) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitCallExpr'");
    }
    
}
