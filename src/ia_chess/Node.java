package ia_chess;

import java.util.ArrayList;

public class Node<T> {
    protected T data;
    protected Position from;
    protected Position to;
    protected boolean visited;
    protected Node<T>father;
    protected ArrayList<Node<T>> childs;
    protected ArrayList<T> path;
    
    public Node(T data, Node<T> father, ArrayList<Node<T>> childs)
    {
        this.data = data;
        this.visited = false;
        this.father = father;
        this.childs = childs;
    }
    
    public Node(T data, Node<T> father)
    {
        this.data = data;
        this.visited = false;
        this.father = father;
        this.childs = new ArrayList<Node<T>>();
    }
    public void setPosition(Position from, Position to){
        this.from = from;
        this.to = to;
    }
    public Position getPosition(){
        return to;
    }
    public Node(T data)
    {
        this.data = data;
        this.visited = false;
        this.father =  null;
        this.childs = new ArrayList<Node<T>>();
    }

    public T getData()
    {
        return data;
    }

    public boolean isVisited()
    {
        return visited;
    }
    
    public Node<T> getFather()
    {
        return this.father;
    }
    
    public ArrayList<Node<T>> getChilds()
    {
        return childs;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }
    
    public void setFather(Node<T> father)
    {
        this.father = father;
    }

    public void setChilds(ArrayList<Node<T>> childs)
    {
        this.childs = childs;
    }
    
    public void insertChild(Node<T> c)
    {
        childs.add(c);
    }
    
    public void insertChild(T c)
    {
        childs.add(new Node<T>(c));
    }
    
    public Node<T> getChildX(int p)
    {
        return childs.get(p);
    }
    public void visit()
    {
        visited = true;
    }
     
    public void unvisit()
    {
        visited = false;
    }
    
    public boolean compareTo(Node<T> ob)
    {
        return this.data == ob.getData();
    }
   
    public ArrayList<T> getPath()
    {
        path = new ArrayList<T>();
        Node<T>node = this;
        while(node!=null){
            path.add(node.getData());
            node = node.getFather();
        }
        return path;
    }
    
    public void printPath()
    {
        for(T s: path)
            System.out.println(s);
    }
    
    public void print()
    {
        print("");
    }
    
    public void print(String inc)
    {
        System.out.println(inc + this.data);
        int t = childs.size();
        inc+=" ";
        for(Node<T> s : childs )
            s.print(inc);
    }
}
