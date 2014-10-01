
public class UnionFindSet {
	int [] set;

	public UnionFindSet(int size){
		size++;
		set = new int[size];
		for(int i=0;i<size;i++){
			set[i] = i;
		}
	}

	public int Find(int idx){
		if(set[idx]==idx) return idx;
		return (set[idx]=Find(set[idx]));
	}

	public void Union(int i, int j){
		set[Find(i)] = Find(j);
	}

	public boolean areConnected(int i, int j){
		return (Find(i)==Find(j));
	}
}
