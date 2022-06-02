public class List {
	private Node head;
	private Node tail;
	
	public List() {
		this.head = null;
		this.tail = null;
	}
	
	private boolean isEmpty() {
		return head == null;
	}
	
	public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
	
	// добавление в начало
	public void addFirst(String lastName, String Name, String middleName, String gender) {
		Node temp = new Node(lastName, Name, middleName, gender);
		
		if (isEmpty()) {
			tail = temp;
		} else {
			head.prev = temp;
		}
		
		temp.next = head;
		head = temp;
	}
	
	// добавление в конец
	public void addLast(String lastName, String Name, String middleName, String gender) {
		Node temp = new Node(lastName, Name, middleName, gender);
		
		if (isEmpty()) {
			head = temp;
		} else {
			tail.next = temp;
		}
		
		temp.prev = tail;
		tail = temp;
	}
	
	// добавление по индексу
	public void addByIndex(int index, String lastName, String Name, String middleName, String gender) {
		Node cur = head;
		int c = 0;
		
		while (cur != null && c != index) {
			cur = cur.next;
			c++;
		}
		
		Node temp = new Node(lastName, Name, middleName, gender);
		cur.prev.next = temp;
		temp.prev = cur.prev;
		cur.prev = temp;
		temp.next = cur;
		
	}
	
	// удаление первого элемента
	public void removeFirst() {
		
		if (head.next == null) {
			tail = null;
		} else {
			head.next.prev = null;
		}
		
		head = head.next;
	}
	
	// удаление последнего элемента
	public void removeLast() {

		if (head.next == null) {
			head = null;
		} else {
			tail.prev.next = null;
		}
			
		tail = tail.prev;
	}
	
	// удаление по ключу
	public void removeAt(String queryLn, boolean onlyFirst) {
		Node cur = head;
		
		while (!cur.lastName.equals(queryLn)){
			cur = cur.next;
			
			if(cur == null) {
				return;
			}
		}
		
		if(cur == head) {
			removeFirst();
		} else {
			cur.prev.next = cur.next;
		}
		
		if(cur == tail) {
			removeLast();
		} else {
			cur.next.prev = cur.prev;
		}
		
		if (onlyFirst) {
            return;
        }
	}
	
}
