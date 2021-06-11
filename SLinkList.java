public class SLinkList{
    private SNode head = null;
    private SNode tail = null;
    public SLinkList(){
        head = null;
    }

    public void setHead(SNode h){
        head = h;
    }

    public void setTail(SNode t){
        head = t;
    }

    public SNode getHead(){
        return head;
    }

    public SNode getTail(){
        return tail;
    }

    public void addNode(SNode p){
        if (head == null){
            head = p;
            tail = p;
        }
        else{
            tail.setNext(p);
            tail = p;
        }
    }

    public SNode findNode(String s){
        boolean found = false;
        SNode q = null;
        for (SNode p = head; p != null && !found; p = p.getNext()){
            found = s.equals(p.getName());
            q = p;
        }
        if (found)
            return q;
        else
            return null;
    }

/*
    public SNode findInsertionPoint(SNode p){
        if (head == null)
            return null;
        else{
            boolean found = false;
            SNode r = null;
            for (SNode q = head; q != null && !found; q = q.getNext()){
                found = q.getName().compareTo(p.getName()) > 0;
            }
        }
        return q;
    }
*/
    public void insertNode(SNode p){
        // if the list is empty
        if (head == null){
            addNode(p);
        }

        // if the new node goes at the front of the list
        else if (p.getName().compareTo(head.getName()) < 0){
            p.setNext(head);
            head = p;
        }

        // if the new node goes somewhere in the list, find the correct placement
        else{
            boolean found = false;
            SNode q = null;
            SNode r = null;

            for (q = head; q != null && !found; q = q.getNext()){
                found = q.getNext() != null && q.getNext().getName().compareTo(p.getName()) > 0;
                r = q;
            }
            p.setNext(q);
            r.setNext(p);

            // if the new node went at the end of the list
            if (!found){
                tail = p;
            }
        }

    }

    public void deleteNode(String key){
        SNode p = findNode(key);
        if (p != null){

            // if p is the only element of the list
            if (head.getNext() == null){
                head = null;
                tail = null;
            }

            // if p is at the front of the list
            else if (p == head){
                head = head.getNext();
            }

            // if p is at the end of the list
            else if (p == tail){
                SNode q = null;
                for (q = head; q.getNext() != p; q = q.getNext());
                tail = q;
                tail.setNext(null);
            }

            // if p is somewhere in the middle of the list
            else{
                SNode q = null;
                for (q = head; q.getNext() != p; q = q.getNext());
                q.setNext(p.getNext());
            }

        }
    }

    public String toString(){
        String s = "";
        for (SNode p = head; p != null; p = p.getNext()){
            s = s + p.toString();
        }
        return s;
    }
}