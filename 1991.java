import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		HashMap<String,Node> tree = new HashMap<>();
		for(int i=0; i<N; i++) {
			String key = Character.toString((char)('A'+i));
			tree.put(key, new Node(key));
		}

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			if(!left.equals("."))
			tree.get(name).left=tree.get(left);
			if(!right.equals("."))
			tree.get(name).right=tree.get(right);
			
		}
		
		search1(tree,tree.get("A"));
		System.out.println();
		search2(tree,tree.get("A"));
		System.out.println();
		search3(tree,tree.get("A"));
		
	}
	
	public static void search1(HashMap<String,Node> tree, Node cur) {
		System.out.print(cur.name);
		if(cur.left!=null)
			search1(tree,cur.left);
		if(cur.right!=null)
			search1(tree,cur.right);
	}
	
	public static void search2(HashMap<String,Node> tree, Node cur) {
		
		if(cur.left!=null)
			search2(tree,cur.left);
		System.out.print(cur.name);
		if(cur.right!=null)
			search2(tree,cur.right);
	}
	
	public static void search3(HashMap<String,Node> tree, Node cur) {
		if(cur.left!=null)
			search3(tree,cur.left);
			
		if(cur.right!=null)
			search3(tree,cur.right);
		System.out.print(cur.name);
	}
}



class Node{
	String name;
	Node left;
	Node right;
	Node(String name){
		this.name = name;
	}
}
