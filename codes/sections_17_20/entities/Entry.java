package sections_17_20.entities;

import java.time.Instant;

public class Entry implements Comparable<Entry>{
    private User user;
    private Instant accessTime;

    public Entry(User user, Instant accessTime){
        this.user = user;
        this.accessTime = accessTime;
    }

    public User getUser(){
        return this.user;
    }

    public Instant getAccessTime(){
        return this.accessTime;
    }

    @Override
    public int compareTo(Entry other){
        return this.accessTime.compareTo(other.accessTime);
    }

    @Override
    public String toString(){
        return this.user + " accessed at " + this.accessTime;
    }
}
