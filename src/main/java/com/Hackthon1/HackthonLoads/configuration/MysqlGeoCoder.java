package com.Hackthon1.HackthonLoads.configuration;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class MysqlGeoCoder {

    public Geometry getGeometryFromText(String text) throws ParseException {
        WKTReader reader = new WKTReader();
        Geometry geo = reader.read(text);
        return geo;
    }

    public Point convertGeoTopPoint(Geometry geometry) {
        Coordinate coordinate = geometry.getCoordinate();
        return new Point(coordinate.x, coordinate.y);
    }
}
