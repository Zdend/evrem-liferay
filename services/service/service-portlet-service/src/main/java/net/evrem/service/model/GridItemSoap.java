package net.evrem.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Zdenek Vecek
 * @generated
 */
public class GridItemSoap implements Serializable {
    private long _gridItemId;
    private long _noteId;
    private int _w;
    private int _h;
    private int _x;
    private int _y;

    public GridItemSoap() {
    }

    public static GridItemSoap toSoapModel(GridItem model) {
        GridItemSoap soapModel = new GridItemSoap();

        soapModel.setGridItemId(model.getGridItemId());
        soapModel.setNoteId(model.getNoteId());
        soapModel.setW(model.getW());
        soapModel.setH(model.getH());
        soapModel.setX(model.getX());
        soapModel.setY(model.getY());

        return soapModel;
    }

    public static GridItemSoap[] toSoapModels(GridItem[] models) {
        GridItemSoap[] soapModels = new GridItemSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static GridItemSoap[][] toSoapModels(GridItem[][] models) {
        GridItemSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new GridItemSoap[models.length][models[0].length];
        } else {
            soapModels = new GridItemSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static GridItemSoap[] toSoapModels(List<GridItem> models) {
        List<GridItemSoap> soapModels = new ArrayList<GridItemSoap>(models.size());

        for (GridItem model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new GridItemSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _gridItemId;
    }

    public void setPrimaryKey(long pk) {
        setGridItemId(pk);
    }

    public long getGridItemId() {
        return _gridItemId;
    }

    public void setGridItemId(long gridItemId) {
        _gridItemId = gridItemId;
    }

    public long getNoteId() {
        return _noteId;
    }

    public void setNoteId(long noteId) {
        _noteId = noteId;
    }

    public int getW() {
        return _w;
    }

    public void setW(int w) {
        _w = w;
    }

    public int getH() {
        return _h;
    }

    public void setH(int h) {
        _h = h;
    }

    public int getX() {
        return _x;
    }

    public void setX(int x) {
        _x = x;
    }

    public int getY() {
        return _y;
    }

    public void setY(int y) {
        _y = y;
    }
}
