public class FixedSizeHashMap {
	
	public static final double DEFAULT_FILL_FRACTION = 0.5;

    protected final int mArraySize;
    
    protected final String[] mKeyTable;

    protected final Object[] mValueTable;
    
    protected int mSize;
    
	public FixedSizeHashMap(int count, double fillFraction) {
		if (fillFraction <= 0.0 || fillFraction > 0.6) {
			throw new IllegalArgumentException("Out of range fill fraction " + fillFraction);
		}
		
		int size = Math.max((int) (count/fillFraction), 11);
		if (size % 2 == 0) {
			size++;
		}
		
		mSize = 0;
		mArraySize = size;
		mKeyTable = new String [mArraySize];
		mValueTable = new Object [mArraySize];
	}
	
	public FixedSizeHashMap(int count) {
		this(count, DEFAULT_FILL_FRACTION);
	}
	
	
	private final int newSlot (String key) {
		return (key.hashCode() & Integer.MAX_VALUE) % mArraySize;
	}

	private final int nextSlot (int slot) {
		return (slot + mArraySize/2) % mArraySize;
	}	
	
	private int findSlotIndex (String key) {

        // find the starting point for searching table
        int slot = newSlot(key);
        int count = 1;
        // scan through table to find target key
        while (mKeyTable[slot] != null) {

            // check if we have a match on target key
            if (mKeyTable[slot].equals(key)) {
                return slot;
            } else {
                slot = nextSlot(slot);
                count++;
                
                //Explored all locations and no location is free
                if (count > mArraySize) {
                	return -1;
                }
            }
        }
        return slot;
    }
	
	boolean set(String key, Object value) {
		//Key should not be null but value can be.
		if (key == null) {
			return false;
		}
		
		int offset = findSlotIndex (key);
		if (offset == -1) {
			return false;
		}
		
		mKeyTable[offset] = key;
		mValueTable[offset] = value;
		mSize++;
		return true;
	}
	
	boolean containsKey (String key) {
		int offset = findSlotIndex(key);
		if (offset != -1 && mKeyTable[offset] != null && mKeyTable[offset].equals(key)) {
			return true;
		}
		return false;
	}
	
	Object delete (String key) throws IllegalArgumentException{
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		
		if (containsKey(key)) {
			int offset = findSlotIndex (key);
			mKeyTable[offset] = null;    //clear the key and not the object
			mSize--;
			return mValueTable[offset];  //return object;
		}
		throw new IllegalArgumentException(key + " is not present in the hash");
	}
	
	/**
	 * Returns the object associated with a key in the hash map
	 * @param key key for which the value is sought
	 * @return value for the key, returns null if key does not exists.
	 */
	Object get (String key) {
		if (containsKey(key)) {
			int offset = findSlotIndex (key);
			return mValueTable[offset];
		}
		return null;
	}
	
	float load() {
		float load = (float) mSize/mArraySize;
		if (load > 1) {
			System.out.println("Load can never be greator than 1. Something is broken");
			throw new IllegalStateException();
		}
		return load;
	}
}
