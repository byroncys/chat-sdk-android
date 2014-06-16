package com.braunster.chatsdk.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import com.braunster.chatsdk.dao.BUserDao;
import com.braunster.chatsdk.dao.BLinkedAccountDao;
import com.braunster.chatsdk.dao.BLinkedContactDao;
import com.braunster.chatsdk.dao.BMetadataDao;
import com.braunster.chatsdk.dao.BMessageDao;
import com.braunster.chatsdk.dao.BThreadDao;
import com.braunster.chatsdk.dao.BLinkDataDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 14): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 14;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        BUserDao.createTable(db, ifNotExists);
        BLinkedAccountDao.createTable(db, ifNotExists);
        BLinkedContactDao.createTable(db, ifNotExists);
        BMetadataDao.createTable(db, ifNotExists);
        BMessageDao.createTable(db, ifNotExists);
        BThreadDao.createTable(db, ifNotExists);
        BLinkDataDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        BUserDao.dropTable(db, ifExists);
        BLinkedAccountDao.dropTable(db, ifExists);
        BLinkedContactDao.dropTable(db, ifExists);
        BMetadataDao.dropTable(db, ifExists);
        BMessageDao.dropTable(db, ifExists);
        BThreadDao.dropTable(db, ifExists);
        BLinkDataDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(BUserDao.class);
        registerDaoClass(BLinkedAccountDao.class);
        registerDaoClass(BLinkedContactDao.class);
        registerDaoClass(BMetadataDao.class);
        registerDaoClass(BMessageDao.class);
        registerDaoClass(BThreadDao.class);
        registerDaoClass(BLinkDataDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}