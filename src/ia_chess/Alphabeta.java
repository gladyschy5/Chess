package ia_chess;

public class Alphabeta {
    public int alphaBeta(Node<Integer> node, int alpha, int beta, boolean maximisingPlayer) 
    {
        int bestValue;

        if (node.getChilds().size() == 0)
            bestValue = node.data;
        else if (maximisingPlayer) {
            bestValue = alpha;
            for (int i=0, c=node.getChilds().size(); i<c; i++) {
                int childValue = alphaBeta(node.getChildX(i), bestValue, beta, false);
                bestValue = Math.max(bestValue, childValue);
                if (beta <= bestValue) {
                    break;
                }
            }
        }
        else {
            bestValue = beta;
            for (int i=0, c=node.getChilds().size(); i<c; i++) {
                int childValue = alphaBeta(node.getChildX(i), alpha, bestValue, true);
                bestValue = Math.min(bestValue, childValue);
                if (bestValue <= alpha) {
                    break;
                }
            }
        }
        return bestValue;
    }
}
