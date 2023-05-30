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
	 * Set the transaction list to the MerkleTree object.
	 * 
	 * @param eoTranx the list of EngineOilTransaction objects
	 */
	private MerkleTree(List<String> tranx) {
		this.eoTranx = tranx;
	}
	
	private static MerkleTree instance;
	
	public static MerkleTree getInstance( List<String> tranx ) {
		if ( instance == null ) {
			return new MerkleTree(tranx);
		}
		return instance;
	}
	
	/**
	 * Build merkle tree 
	 */
	public void build() {
		List<String> tempLst = new ArrayList<>();
		
		for (String tranx : eoTranx) {
			tempLst.add(tranx.toString());
		}
		
		List<String> hashes = generateTransactionHashes( tempLst );
		while (hashes.size() != 1) {
			hashes = generateTransactionHashes( hashes );
		}
		this.root = hashes.get(0);
	}
	
	/**
	 * Generate hashes of transactions 
	 * 
     * @param tranxList the list of transaction strings
     * @return the list of generated transaction hashes
	 */
	private List<String> generateTransactionHashes(List<String> eoTranx) {
		List<String> hashLst = new ArrayList<>();
		int i = 0;
		while( i < eoTranx.size()) {
			
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
