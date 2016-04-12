package com.redknot.domain;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by miaoyuqiao on 16/4/12.
 */
public class PathList {
    private ArrayList<Point> points = new ArrayList<>();

    public void addPoint(Point point) {
        this.points.add(point);
    }

    public Point getLastPoint() {
        return this.points.get(points.size() - 1);
    }

    public int getSize() {
        return this.points.size();
    }

    public Point getPoint(int index) {
        return this.points.get(index);
    }

    public void clearPath() {
        this.points.clear();
    }

    public void removeLast() {
        points.remove(points.size() - 1);
    }

    public String toString() {
        JSONArray ja = new JSONArray();
        for (Point p : points) {
            JSONObject object = new JSONObject();
            try {
                object.put("x",p.getX());
                object.put("y",p.getY());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ja.put(object);
        }
        return ja.toString();
    }
}
