import javafx.util.Pair;

import java.util.*;

public class AStarSearch   extends ASearch
{
	// Define lists here ...
	private HashMap<ASearchNode, Pair<Integer,ASearchNode>> hashNodes;
	private PriorityQueue<ASearchNode> openList;
//	private List<ASearchNode> closeList;
	
	@Override
	public String getSolverName() 
	{
		return "AStar";
	}
	
	@Override
	public ASearchNode createSearchRoot(TopSpinPuzzleState problemState)
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists()
	{
		openList = new PriorityQueue<>(new Comparator<ASearchNode>() {
			@Override
			public int compare(ASearchNode node1, ASearchNode node2) {
				if (node1.F() > node2.F())
					return 1;
				else if (node1.F() < node2.F())
					return -1;
				return 0;
			}
		});
		hashNodes = new HashMap<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if (isOpen(node)){
			return hashNodes.get(node).getValue();
		}

		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		if (hashNodes.containsKey(node) && hashNodes.get(node).getKey() == 1)
			return true;
		return false;
	}

	@Override
	public boolean isClosed(ASearchNode node)
	{
		if (hashNodes.containsKey(node) && hashNodes.get(node).getKey() == 0)
			return true;
		return false;
	}

	@Override
	public void addToOpen(ASearchNode node)
	{
		Pair p = new Pair(1,node);
		if (hashNodes.containsKey(node)){
			hashNodes.replace(node,p);
		}
		else
			hashNodes.put(node, p);
		openList.add(node);
	}


	@Override
	public void addToClosed(ASearchNode node)
	{
		if(hashNodes.containsKey(node)) {
			Pair p = new Pair(0,node);
			hashNodes.remove(node);
			hashNodes.put(node, p);
		}
	}

	@Override
	public int openSize()
	{
		return openList.size();
	}

	@Override
	public ASearchNode getBest()
	{
		return openList.remove();
	}


}