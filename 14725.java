import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
	static int N,ret;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		
		for(int k=0; k<N; k++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] arr = new String[K];
			for(int i=0; i<K; i++) {
				arr[i]=st.nextToken();
			}
			trie.insert(arr);
		}
		
		trie.print();
		
	}
	
}

class Trie{
	TrieNode root = new TrieNode(0);
	
	public void insert(String[] arr) {
		TrieNode now = root;
		
		for(int i=0; i<arr.length; i++) {
			String str = arr[i];
			if(!now.child.containsKey(str)) {
				now.child.put(str,new TrieNode(now.depth+1));
			}
			now = now.child.get(str);
		}
	}
	
	public void print() {
		TrieNode now = root;
		
		for(String key:now.child.keySet()) {
			System.out.println(key);
			printNode(now.child.get(key));
		}
	}
	
	public void printNode(TrieNode node) {
		for(String key:node.child.keySet()) {
			for(int i=0; i<node.depth; i++) {
				System.out.print("--");
			}
			System.out.println(key);
			printNode(node.child.get(key));
		}
	}
}

class TrieNode{
	TreeMap<String,TrieNode> child = new TreeMap<>();
	int depth;
	TrieNode(int depth){
		this.depth = depth;
	}
	
	public int getDepth() {
		return depth;
	}
	
}

