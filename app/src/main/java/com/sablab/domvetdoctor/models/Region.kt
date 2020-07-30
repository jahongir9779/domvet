package com.sablab.domvetdoctor.models

import androidx.room.ColumnInfo
import com.sablab.domvetdoctor.data.db.entries.ERegion

class Region(@ColumnInfo(name = ERegion.COLUMN_REGION_ID) val regionId: String,
             @ColumnInfo(name = ERegion.COLUMN_REGION_NAME) val regionName: String,
             @ColumnInfo(name = ERegion.COLUMN_REGION_SLUG) val regionSlug: String,
             @ColumnInfo(name = ERegion.COLUMN_CODE) val countryCode: String,
             @ColumnInfo(name = ERegion.COLUMN_STATUS) val status: String,
             @ColumnInfo(name = ERegion.COLUMN_UTC) val utc: String)