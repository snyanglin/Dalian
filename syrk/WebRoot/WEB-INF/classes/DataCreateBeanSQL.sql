select '@FieldDesc("'|| COMMENTS ||'")' || decode(DATATYPE,'NUMBER','private Long ','private String ') || lower(COLUMN_NAME) || ';' from (
   select a.TABLE_NAME,a.COLUMN_NAME,decode(substr(a.DATA_TYPE,1,9),'UNDEFINED','VARCHAR2','NCHAR','CHAR','NVARCHAR2','VARCHAR2','FLOAT','NUMBER','TIMESTAMP','DATE',a.DATA_TYPE) as DATATYPE,
      to_char(decode(a.DATA_LENGTH,0,100,a.DATA_LENGTH)) as DATA_LENGTH,decode(b.COMMENTS,null,a.COLUMN_NAME,b.COMMENTS) as COMMENTS  
      from USER_TAB_COLUMNS a,USER_COL_COMMENTS b 
      where a.TABLE_NAME=b.TABLE_NAME and a.COLUMN_NAME=b.COLUMN_NAME and a.TABLE_NAME=upper('RK_ZDRYLBZB') -- ±íÃû RK_RYJBXXB
      order by a.COLUMN_ID
)
