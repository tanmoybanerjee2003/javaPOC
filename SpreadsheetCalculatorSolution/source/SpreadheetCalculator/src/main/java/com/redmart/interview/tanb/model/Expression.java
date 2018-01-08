/**
 * 
 */
package com.redmart.interview.tanb.model;

import java.util.Deque;
import java.util.LinkedList;

import com.redmart.interview.tanb.util.PatternUtil;

/**
 * 
 * This class evaluates the postfix expression.
 * Stack is used for evaluation.
 * 
 * @author tanmoy
 *
 */
public class Expression {
	private Deque<Double> operandStack;
	private String expression;
	
	public Expression(String expression) {
		operandStack = new LinkedList<Double>();
		this.expression = expression;
	}
	
	public double value() {
		double result = 0.0;
		
		String[] tokens = expression.split("\\s");
		for(int i=0; i<tokens.length; i++) {
			if(PatternUtil.isNumber(tokens[i])) {
				//push to stack
				operandStack.addLast(Double.parseDouble(tokens[i]));
			} else if(PatternUtil.isBinaryOperator(tokens[i])) {
				String operator = tokens[i];
				//pop two operands from the stack
				double operand2 = operandStack.removeLast();
				double operand1 = operandStack.removeLast();
				double opResult = 0;
				
				switch(operator.trim()) {
				case "*": opResult = operand1 * operand2; break;
				case "+": opResult = operand1 + operand2; break;
				case "-": opResult = operand1 - operand2; break;
				case "/": opResult = operand1 / operand2; break;
				}
				
				//push the result in the stack
				operandStack.addLast(opResult);
			}
		}
		
		//pop final result
		result = operandStack.removeLast();
		
		return result;
	}

}
