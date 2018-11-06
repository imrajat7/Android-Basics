package com.example.android.inventoryapp1.data;

import android.provider.BaseColumns;

public class BookContract {

    public static abstract class BookEntry implements BaseColumns {

        public static final String TABLE_NAME = "books";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_BOOK_NAME = "book_name";
        public static final String COLUMN_BOOK_PRICE = "price";
        public static final String COLUMN_BOOK_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier";
        public static final String COLUMN_SUPPLIER_NO = "number";
    }
}