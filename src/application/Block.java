package application;

import java.io.Serializable;
import java.sql.Timestamp;

public class Block {

	private static final long serialVersionUID = 1L;
	
	/* relationship implementation */
	public Header header;
	public EngineOilTransaction eoTranx;
	
	public Block(String previousHash) {
		 /* composition relationship */
		this.header = new Header();
		this.header.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
		header.setPreviousHash(previousHash);
		String info = String.join("+", Integer.toString(header.getIndex()),
				Long.toString(header.getTimestamp()), header.getPreviousHash());
		String blockHash = Hasher.sha256(info);
		header.setCurrentHash(blockHash);
	}
	
	public EngineOilTransaction getTransaction() {
		return this.eoTranx;
	}
	
	/* aggregation relationship */
	public void setTransactions(EngineOilTransaction eoTranx) {
		this.eoTranx = eoTranx;
	}
	
	public Header getHeader() {
		return this.header;
	}
	
	@Override
	public String toString() {
		return "Block [header=" + header + ", eoTranx=" + eoTranx + "]";
	}

	public class Header implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		public int index;
	    public String currentHash, previousHash;
	    public long timestamp;
	    
	    //setters and getters
		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public String getCurrentHash() {
			return currentHash;
		}

		public void setCurrentHash(String currentHash) {
			this.currentHash = currentHash;
		}

		public String getPreviousHash() {
			return previousHash;
		}

		public void setPreviousHash(String previousHash) {
			this.previousHash = previousHash;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		@Override
		public String toString() {
			return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
					+ ", timestamp=" + timestamp + "]";
		}
	}
	
}
