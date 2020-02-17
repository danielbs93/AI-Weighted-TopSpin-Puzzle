import java.util.*;

public class BreadthFirstSearch  extends ASearch
{
	private Queue<ASearchNode> openList;
//	private List<ASearchNode> closeList;
	private HashMap<ASearchNode,Integer> hashNodes;
	// Define lists here ...
	
	@Override
	public String getSolverName() 
	{
		return "BFS";
	}

	@Override
	public ASearchNode createSearchRoot(TopSpinPuzzleState problemState)
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		openList = new LinkedList<>();
//		closeList = new LinkedList<>();
		hashNodes = new HashMap<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if (isOpen(node))
			return node;
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		if (hashNodes.containsKey(node) && hashNodes.get(node) == 1)
			return true;
		return false;
	}
	
	@Override
	public boolean isClosed(ASearchNode node)
	{
		if (hashNodes.containsKey(node) && hashNodes.get(node) == 0)
			return true;
		return false;
	}

	

	@Override
	public void addToOpen(ASearchNode node)
	{
		if (hashNodes.containsKey(node)){
			hashNodes.replace(node,1);
		}
		else
			hashNodes.put(node, 1);
		openList.add(node);

	}

	@Override
	public void addToClosed(ASearchNode node)
	{
		if(hashNodes.containsKey(node)) {
			hashNodes.remove(node);
			hashNodes.put(node, 0);
		}
//		closeList.add(node);
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