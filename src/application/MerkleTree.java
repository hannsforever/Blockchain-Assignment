package application;

import java.util.ArrayList;
import java.util.List;

public class MerkleTree {

	private List<String> eoTranx;
	private String root = "0";
	
	public String getRoot() {
		return root;
	}
	
	/**
	 * @implNote
	 * Set the transaction list to the MerkleTree object.
	 * 
	 * @param tranxLst
	 */
	private MerkleTree(List<String> eoTranx) {
		super();
		this.eoTranx = eoTranx;
	}
	
	private static MerkleTree instance;
	public static MerkleTree getInstance( List<String> eoTranx ) {
		if ( instance == null ) {
			return new MerkleTree(eoTranx);
		}
		return instance;
	}
	
	/**
	 * @implNote
	 * Build merkle tree 
	 * 
	 * @implSpec 
	 * + build() : void
	 */
	public void build() {
		List<String> tempLst = new ArrayList<>();
		
		for (String tranx : this.eoTranx) {
			tempLst.add(tranx);
		}
		
		List<String> hashes = genTranxHashLst( tempLst );
		while (hashes.size() != 1) {
			hashes = genTranxHashLst( hashes );
		}
		this.root = hashes.get(0);
	}
	
	/**
	 * @implNote
	 * Generate hashes of transactions 
	 * 
	 * @implSpec 
	 * - genTranxHashLst(List<String>) : List<String>
	 */
	private List<String> genTranxHashLst(List<String> eoTranx) {
		List<String> hashLst = new ArrayList<>();
		int i = 0;
		while( i < eoTranx.size() ) {
			
			String left = eoTranx.get(i);
			i++;
			
			String right = "";
			if( i != eoTranx.size() ) right = eoTranx.get(i);
			
			String hash = Hasher.sha256(left.concat(right));
			hashLst.add(hash);
			i++;
		}
		return hashLst;
	}
	
}
