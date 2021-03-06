package com.teamruse.rarerare.tritontravel;

import java.util.ArrayList;

/**
 * Created by Shuyuan Ma on 2017/12/8.
 */

public class PathResult{
    /*
     * Shuyuan Ma @Dec 8th
     * Implement Parcelable for bottom sheet.
     * I will only parcel the necessary data for bottom sheet display in the following order:
     *      String Duration
     *      String[] (walking or bus short_name)
     */
    //public LatLng mStartLocation;
    //public LatLng mEndLocation;
    public String mDuration;
    public ArrayList<String> segments;

    public PathResult(Path path) {
        //mStartLocation = path.getStartLocation();
        //mEndLocation = path.getEndLocation();
        mDuration = path.getDuration();
        segments = new ArrayList<String>();

        ArrayList<PathSegment> recPathSegments = path.getPathSegments();
        for (int i = 0; i < recPathSegments.size(); ++i) {
            PathSegment currSegment = recPathSegments.get(i);
            switch (currSegment.getTravelMode()) {
                case BUS:
                    BusSegment currbusSegment = (BusSegment)currSegment;
                    segments.add(currbusSegment.getBusName());
                    break;
                case SHUTTLE:
                    ShuttleSegment currshuttleSegment = (ShuttleSegment)currSegment;
                    segments.add(currshuttleSegment.getShuttleHeadsign());
                    break;
                case WALKING:
                    segments.add("Walking");
                    break;
            }
        }
    }
}