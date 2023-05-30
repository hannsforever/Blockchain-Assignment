package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EngineOilTransaction implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private final int SIZE = 10;
    public String merkleRoot;
    
    private List<String> eoTranx;
    
    public EngineOilTransaction() {
    	eoTranx = new ArrayList<>(SIZE);
    }
    
    public List<String> getEngineOilTransaction() {
    	return this.eoTranx;
    }
    
    public void add(String tranx) {
    	eoTranx.add(tranx);
    }
    
    public void setMerkleRoot(String root) {
    	this.merkleRoot = root;
    }
    
    public String getMerkleRoot() {
    	return this.merkleRoot;
    }

	@Override
	public String toString() {
		return "EngineOilTransaction [merkleRoot=" + merkleRoot + ", eoTranx=" + eoTranx + "]";
	}
}
