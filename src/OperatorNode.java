/**
 * Operator nodes are the internal nodes of a binary expression tree.
 *
 * @author Ryan Setzer
 * @version 1.0
 */
public class OperatorNode extends ExpressionNode {

  private Operator op;

  public OperatorNode(Operator op) {
    super();
    this.op = op;
  }

  public OperatorNode(Operator op, ExpressionNode left, ExpressionNode right) {
    super(left, right);
    this.op = op;
  }

  /**
   * Evaluate the expression rooted at this node and return the result.
   */
  @Override
  public double evaluate() {
    // UNFINISHED.
    if (left() == null) {
      return evaluate();
    }
    if (op.opString().equals("+")) {
      return left().evaluate() + right().evaluate();
    } else if (op.opString().equals("-")) {
      return left().evaluate() - right().evaluate();
    } else if (op.opString().equals("*")) {
      return left().evaluate() * right().evaluate();
    } else {
      return left().evaluate() / right().evaluate();
    }
  }

  @Override
  public String postfixString() {
    // UNFINISHED (See superclass javadocs for requirements.)
    if (left() == null) {
      return toString();
    }
    return left().postfixString() + " " + right().postfixString() + " " + op.opString();
  }

  @Override
  public String prefixString() {
    // UNFINISHED
    if (left() == null) {
      return toString();
    }
    return op.opString() + " " + left().prefixString() + " " + right().prefixString();

  }

  @Override
  public String infixString() {
    // UNFINISHED
    if (left() == null) {
      return toString();
    }
    return "(" + left().infixString() + " " + op.opString() + " " + right().infixString() + ")";
  }
}

