package ia_chess;

public class Alphabeta {
    public Node<Integer> alphaBeta(Node<Integer> root){
        Node<Integer> solution = null;
        alphaBeta(root, 1000000, -1000000, true, solution);
        return solution;
    }
    public int alphaBeta(Node<Integer> node, int alpha, int beta, boolean maximisingPlayer, Node<Integer> solution) 
    {
        int bestValue;

        if (node.getChilds().isEmpty())
            bestValue = node.data;
        else if (maximisingPlayer) {
            bestValue = alpha;
            for (int i=0, c=node.getChilds().size(); i<c; i++) {
                int childValue = alphaBeta(node.getChildX(i), bestValue, beta, false, solution);
                bestValue = Math.max(bestValue, childValue);
                if (beta <= bestValue) {
                    solution = node.getChildX(i); 
                    break;
                }
            }
        }
        else {
            bestValue = beta;
            for (int i=0, c=node.getChilds().size(); i<c; i++) {
                int childValue = alphaBeta(node.getChildX(i), alpha, bestValue, true, solution);
                bestValue = Math.min(bestValue, childValue);
                if (bestValue <= alpha) {
                    solution = node.getChildX(i); 
                    break;
                }
            }
        }
        return bestValue;
    }
}
