package net.squadleader.meetups;

public class DateSorter implements Comparable<Meetup> {

	
	public int compareTo(Meetup one, Meetup another) {
		return one.getEVENT_DATE().compareTo(another.getEVENT_DATE());
	}

    public int compare(Meetup one, Meetup another){
        int returnVal = 0;

    if(one.getEVENT_DATE() < another.getEVENT_DATE()){
        returnVal =  -1;
    }else if(one.getPrice() > another.getPrice()){
        returnVal =  1;
    }else if(one.getPrice() == another.getPrice()){
        returnVal =  0;
    }
    return returnVal;

    }
}


}
