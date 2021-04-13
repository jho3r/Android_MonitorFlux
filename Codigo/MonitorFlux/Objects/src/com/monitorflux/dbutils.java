package com.monitorflux;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class dbutils {
private static dbutils mostCurrent = new dbutils();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _db_real = "";
public static String _db_integer = "";
public static String _db_blob = "";
public static String _db_text = "";
public static String _htmlcss = "";
public com.monitorflux.main _main = null;
public com.monitorflux.starter _starter = null;
public com.monitorflux.tutoriales_activity _tutoriales_activity = null;
public com.monitorflux.agregar_activity _agregar_activity = null;
public com.monitorflux.monitor_activity _monitor_activity = null;
public com.monitorflux.datos_activity _datos_activity = null;
public com.monitorflux.registrar_activity _registrar_activity = null;
public com.monitorflux.httputils2service _httputils2service = null;
public static class _dbfieldinfo{
public boolean IsInitialized;
public String FieldName;
public String DataType;
public boolean CanBeNull;
public Object DefValue;
public void Initialize() {
IsInitialized = true;
FieldName = "";
DataType = "";
CanBeNull = false;
DefValue = new Object();
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _copydbfromassets(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
String _targetdir = "";
 //BA.debugLineNum = 52;BA.debugLine="Public Sub CopyDBFromAssets (FileName As String) A";
 //BA.debugLineNum = 53;BA.debugLine="Dim TargetDir As String = GetDBFolder";
_targetdir = _getdbfolder(_ba);
 //BA.debugLineNum = 54;BA.debugLine="If File.Exists(TargetDir, FileName) = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_targetdir,_filename)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 55;BA.debugLine="File.Copy(File.DirAssets, FileName, TargetDir, F";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_filename,_targetdir,_filename);
 };
 //BA.debugLineNum = 57;BA.debugLine="Return TargetDir";
if (true) return _targetdir;
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _createtable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _fieldsandtypes,String _primarykey) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _field = "";
String _ftype = "";
String _query = "";
 //BA.debugLineNum = 96;BA.debugLine="Public Sub CreateTable(SQL As SQL, TableName As St";
 //BA.debugLineNum = 97;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 98;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 99;BA.debugLine="sb.Append(\"(\")";
_sb.Append("(");
 //BA.debugLineNum = 100;BA.debugLine="For i = 0 To FieldsAndTypes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fieldsandtypes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
 //BA.debugLineNum = 101;BA.debugLine="Dim field, ftype As String";
_field = "";
_ftype = "";
 //BA.debugLineNum = 102;BA.debugLine="field = FieldsAndTypes.GetKeyAt(i)";
_field = BA.ObjectToString(_fieldsandtypes.GetKeyAt(_i));
 //BA.debugLineNum = 103;BA.debugLine="ftype = FieldsAndTypes.GetValueAt(i)";
_ftype = BA.ObjectToString(_fieldsandtypes.GetValueAt(_i));
 //BA.debugLineNum = 104;BA.debugLine="If i > 0 Then sb.Append(\", \")";
if (_i>0) { 
_sb.Append(", ");};
 //BA.debugLineNum = 105;BA.debugLine="sb.Append(EscapeField(field)).Append(\" \").Append";
_sb.Append(_escapefield(_ba,_field)).Append(" ").Append(_ftype);
 //BA.debugLineNum = 106;BA.debugLine="If field = PrimaryKey Then sb.Append(\" PRIMARY K";
if ((_field).equals(_primarykey)) { 
_sb.Append(" PRIMARY KEY");};
 }
};
 //BA.debugLineNum = 108;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
 //BA.debugLineNum = 109;BA.debugLine="Dim query As String = \"CREATE TABLE IF NOT EXISTS";
_query = "CREATE TABLE IF NOT EXISTS "+_escapefield(_ba,_tablename)+" "+_sb.ToString();
 //BA.debugLineNum = 111;BA.debugLine="Log(\"CreateTable: \" & query)";
anywheresoftware.b4a.keywords.Common.LogImpl("98781839","CreateTable: "+_query,0);
 //BA.debugLineNum = 113;BA.debugLine="SQL.ExecNonQuery(query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public static String  _deleterecord(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
String _col = "";
 //BA.debugLineNum = 490;BA.debugLine="Public Sub DeleteRecord(SQL As SQL, TableName As S";
 //BA.debugLineNum = 491;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 492;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 493;BA.debugLine="sb.Append(\"DELETE FROM \" & EscapeField(TableName)";
_sb.Append("DELETE FROM "+_escapefield(_ba,_tablename)+" WHERE ");
 //BA.debugLineNum = 494;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
if (_wherefieldequals.getSize()==0) { 
 //BA.debugLineNum = 495;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("99764869","WhereFieldEquals map empty!",0);
 //BA.debugLineNum = 496;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 498;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 499;BA.debugLine="args.Initialize";
_args.Initialize();
 //BA.debugLineNum = 500;BA.debugLine="For Each col As String In WhereFieldEquals.Keys";
{
final anywheresoftware.b4a.BA.IterableList group10 = _wherefieldequals.Keys();
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_col = BA.ObjectToString(group10.Get(index10));
 //BA.debugLineNum = 501;BA.debugLine="If args.Size > 0 Then sb.Append(\" AND \")";
if (_args.getSize()>0) { 
_sb.Append(" AND ");};
 //BA.debugLineNum = 502;BA.debugLine="sb.Append(EscapeField(col)).Append(\" = ?\")";
_sb.Append(_escapefield(_ba,_col)).Append(" = ?");
 //BA.debugLineNum = 503;BA.debugLine="args.Add(WhereFieldEquals.Get(col))";
_args.Add(_wherefieldequals.Get((Object)(_col)));
 }
};
 //BA.debugLineNum = 506;BA.debugLine="Log(\"DeleteRecord: \" & sb.ToString)";
anywheresoftware.b4a.keywords.Common.LogImpl("99764880","DeleteRecord: "+_sb.ToString(),0);
 //BA.debugLineNum = 508;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
_sql.ExecNonQuery2(_sb.ToString(),_args);
 //BA.debugLineNum = 509;BA.debugLine="End Sub";
return "";
}
public static String  _droptable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename) throws Exception{
String _query = "";
 //BA.debugLineNum = 118;BA.debugLine="Public Sub DropTable(SQL As SQL, TableName As Stri";
 //BA.debugLineNum = 119;BA.debugLine="Dim query As String = \"DROP TABLE IF EXISTS\" & Es";
_query = "DROP TABLE IF EXISTS"+_escapefield(_ba,_tablename);
 //BA.debugLineNum = 121;BA.debugLine="Log(\"DropTable: \" & query)";
anywheresoftware.b4a.keywords.Common.LogImpl("98847363","DropTable: "+_query,0);
 //BA.debugLineNum = 123;BA.debugLine="SQL.ExecNonQuery(query)";
_sql.ExecNonQuery(_query);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static String  _escapefield(anywheresoftware.b4a.BA _ba,String _f) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Private Sub EscapeField(f As String) As String";
 //BA.debugLineNum = 66;BA.debugLine="Return \"[\" & f & \"]\"";
if (true) return "["+_f+"]";
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _executehtml(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,boolean _clickable) throws Exception{
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
int _row = 0;
 //BA.debugLineNum = 365;BA.debugLine="Public Sub ExecuteHtml(SQL As SQL, Query As String";
 //BA.debugLineNum = 366;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
 //BA.debugLineNum = 367;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
 //BA.debugLineNum = 368;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
 }else {
 //BA.debugLineNum = 370;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery(_query)));
 };
 //BA.debugLineNum = 373;BA.debugLine="Log(\"ExecuteHtml: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("99437192","ExecuteHtml: "+_query,0);
 //BA.debugLineNum = 376;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 377;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 378;BA.debugLine="sb.Append(\"<html><body>\").Append(CRLF)";
_sb.Append("<html><body>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 379;BA.debugLine="sb.Append(\"<style type='text/css'>\").Append(HtmlC";
_sb.Append("<style type='text/css'>").Append(_htmlcss).Append("</style>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 380;BA.debugLine="sb.Append(\"<table><thead><tr>\").Append(CRLF)";
_sb.Append("<table><thead><tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 381;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
 //BA.debugLineNum = 382;BA.debugLine="sb.Append(\"<th>\").Append(cur.GetColumnName(i)).A";
_sb.Append("<th>").Append(_cur.GetColumnName(_i)).Append("</th>");
 }
};
 //BA.debugLineNum = 384;BA.debugLine="sb.Append(\"</thead>\")";
_sb.Append("</thead>");
 //BA.debugLineNum = 394;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
_sb.Append("</tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 395;BA.debugLine="Dim row As Int";
_row = 0;
 //BA.debugLineNum = 396;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 397;BA.debugLine="If row Mod 2 = 0 Then";
if (_row%2==0) { 
 //BA.debugLineNum = 398;BA.debugLine="sb.Append(\"<tr>\")";
_sb.Append("<tr>");
 }else {
 //BA.debugLineNum = 400;BA.debugLine="sb.Append(\"<tr class='odd'>\")";
_sb.Append("<tr class='odd'>");
 };
 //BA.debugLineNum = 402;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step25 = 1;
final int limit25 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit25 ;_i = _i + step25 ) {
 //BA.debugLineNum = 403;BA.debugLine="sb.Append(\"<td>\")";
_sb.Append("<td>");
 //BA.debugLineNum = 404;BA.debugLine="If Clickable Then";
if (_clickable) { 
 //BA.debugLineNum = 405;BA.debugLine="sb.Append(\"<a href='http://\").Append(i).Append";
_sb.Append("<a href='http://").Append(BA.NumberToString(_i)).Append(".");
 //BA.debugLineNum = 406;BA.debugLine="sb.Append(row)";
_sb.Append(BA.NumberToString(_row));
 //BA.debugLineNum = 407;BA.debugLine="sb.Append(\".stub'>\").Append(cur.GetString2(i))";
_sb.Append(".stub'>").Append(_cur.GetString2(_i)).Append("</a>");
 }else {
 //BA.debugLineNum = 409;BA.debugLine="sb.Append(cur.GetString2(i))";
_sb.Append(_cur.GetString2(_i));
 };
 //BA.debugLineNum = 411;BA.debugLine="sb.Append(\"</td>\")";
_sb.Append("</td>");
 }
};
 //BA.debugLineNum = 413;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
_sb.Append("</tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 414;BA.debugLine="row = row + 1";
_row = (int) (_row+1);
 }
;
 //BA.debugLineNum = 416;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 417;BA.debugLine="sb.Append(\"</table></body></html>\")";
_sb.Append("</table></body></html>");
 //BA.debugLineNum = 418;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 419;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _executejson(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.collections.List _dbtypes) throws Exception{
anywheresoftware.b4a.objects.collections.List _table = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _root = null;
 //BA.debugLineNum = 325;BA.debugLine="Public Sub ExecuteJSON (SQL As SQL, Query As Strin";
 //BA.debugLineNum = 326;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 327;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
 //BA.debugLineNum = 328;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
 //BA.debugLineNum = 329;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
 }else {
 //BA.debugLineNum = 331;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery(_query)));
 };
 //BA.debugLineNum = 334;BA.debugLine="Log(\"ExecuteJSON: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("99371657","ExecuteJSON: "+_query,0);
 //BA.debugLineNum = 336;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 337;BA.debugLine="table.Initialize";
_table.Initialize();
 //BA.debugLineNum = 338;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 339;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 340;BA.debugLine="m.Initialize";
_m.Initialize();
 //BA.debugLineNum = 341;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step14 = 1;
final int limit14 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
 //BA.debugLineNum = 342;BA.debugLine="Select DBTypes.Get(i)";
switch (BA.switchObjectToInt(_dbtypes.Get(_i),(Object)(_db_text),(Object)(_db_integer),(Object)(_db_real))) {
case 0: {
 //BA.debugLineNum = 344;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetString2(i)";
_m.Put((Object)(_cur.GetColumnName(_i)),(Object)(_cur.GetString2(_i)));
 break; }
case 1: {
 //BA.debugLineNum = 346;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetLong2(i))";
_m.Put((Object)(_cur.GetColumnName(_i)),(Object)(_cur.GetLong2(_i)));
 break; }
case 2: {
 //BA.debugLineNum = 348;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetDouble2(i)";
_m.Put((Object)(_cur.GetColumnName(_i)),(Object)(_cur.GetDouble2(_i)));
 break; }
default: {
 //BA.debugLineNum = 350;BA.debugLine="Log(\"Invalid type: \" & DBTypes.Get(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("99371673","Invalid type: "+BA.ObjectToString(_dbtypes.Get(_i)),0);
 break; }
}
;
 }
};
 //BA.debugLineNum = 353;BA.debugLine="table.Add(m)";
_table.Add((Object)(_m.getObject()));
 //BA.debugLineNum = 354;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
if (_limit>0 && _table.getSize()>=_limit) { 
if (true) break;};
 }
;
 //BA.debugLineNum = 356;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 357;BA.debugLine="Dim root As Map";
_root = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 358;BA.debugLine="root.Initialize";
_root.Initialize();
 //BA.debugLineNum = 359;BA.debugLine="root.Put(\"root\", table)";
_root.Put((Object)("root"),(Object)(_table.getObject()));
 //BA.debugLineNum = 360;BA.debugLine="Return root";
if (true) return _root;
 //BA.debugLineNum = 361;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _executelist(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit) throws Exception{
anywheresoftware.b4a.objects.collections.List _table = null;
anywheresoftware.b4a.objects.collections.List _res = null;
String[] _cols = null;
 //BA.debugLineNum = 305;BA.debugLine="Public Sub ExecuteList(SQL As SQL, Query As String";
 //BA.debugLineNum = 306;BA.debugLine="Dim Table As List = ExecuteMemoryTable(SQL, Query";
_table = new anywheresoftware.b4a.objects.collections.List();
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);
 //BA.debugLineNum = 307;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 308;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 309;BA.debugLine="For Each Cols() As String In Table";
{
final anywheresoftware.b4a.BA.IterableList group4 = _table;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_cols = (String[])(group4.Get(index4));
 //BA.debugLineNum = 310;BA.debugLine="res.Add(Cols(0))";
_res.Add((Object)(_cols[(int) (0)]));
 }
};
 //BA.debugLineNum = 312;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 313;BA.debugLine="End Sub";
return null;
}
public static String  _executelist2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.collections.List _list) throws Exception{
 //BA.debugLineNum = 300;BA.debugLine="Public Sub ExecuteList2(SQL As SQL, Query As Strin";
 //BA.debugLineNum = 301;BA.debugLine="List.Clear";
_list.Clear();
 //BA.debugLineNum = 302;BA.debugLine="List.AddAll(ExecuteList(SQL, Query, StringArgs, L";
_list.AddAll(_executelist(_ba,_sql,_query,_stringargs,_limit));
 //BA.debugLineNum = 303;BA.debugLine="End Sub";
return "";
}
public static String  _executelistview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.ListViewWrapper _listview1,boolean _twolines) throws Exception{
anywheresoftware.b4a.objects.collections.List _table = null;
String[] _cols = null;
int _i = 0;
 //BA.debugLineNum = 256;BA.debugLine="Public Sub ExecuteListView(SQL As SQL, Query As St";
 //BA.debugLineNum = 258;BA.debugLine="ListView1.Clear";
_listview1.Clear();
 //BA.debugLineNum = 259;BA.debugLine="Dim Table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 260;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);
 //BA.debugLineNum = 261;BA.debugLine="Dim Cols() As String";
_cols = new String[(int) (0)];
java.util.Arrays.fill(_cols,"");
 //BA.debugLineNum = 262;BA.debugLine="For i = 0 To Table.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_table.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 263;BA.debugLine="Cols = Table.Get(i)";
_cols = (String[])(_table.Get(_i));
 //BA.debugLineNum = 264;BA.debugLine="If TwoLines Then";
if (_twolines) { 
 //BA.debugLineNum = 265;BA.debugLine="ListView1.AddTwoLines2(Cols(0), Cols(1), Cols)";
_listview1.AddTwoLines2(BA.ObjectToCharSequence(_cols[(int) (0)]),BA.ObjectToCharSequence(_cols[(int) (1)]),(Object)(_cols));
 }else {
 //BA.debugLineNum = 267;BA.debugLine="ListView1.AddSingleLine2(Cols(0), Cols)";
_listview1.AddSingleLine2(BA.ObjectToCharSequence(_cols[(int) (0)]),(Object)(_cols));
 };
 }
};
 //BA.debugLineNum = 270;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _executemap(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs) throws Exception{
anywheresoftware.b4a.objects.collections.Map _res = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
int _i = 0;
 //BA.debugLineNum = 213;BA.debugLine="Public Sub ExecuteMap(SQL As SQL, Query As String,";
 //BA.debugLineNum = 214;BA.debugLine="Dim res As Map";
_res = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 215;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
 //BA.debugLineNum = 216;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
 //BA.debugLineNum = 217;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
 }else {
 //BA.debugLineNum = 219;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery(_query)));
 };
 //BA.debugLineNum = 222;BA.debugLine="Log(\"ExecuteMap: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("99043977","ExecuteMap: "+_query,0);
 //BA.debugLineNum = 224;BA.debugLine="If cur.NextRow = False Then";
if (_cur.NextRow()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 226;BA.debugLine="Log(\"No records found.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("99043981","No records found.",0);
 //BA.debugLineNum = 228;BA.debugLine="Return res";
if (true) return _res;
 };
 //BA.debugLineNum = 230;BA.debugLine="res.Initialize";
_res.Initialize();
 //BA.debugLineNum = 231;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step14 = 1;
final int limit14 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
 //BA.debugLineNum = 232;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.Ge";
_res.Put((Object)(_cur.GetColumnName(_i).toLowerCase()),(Object)(_cur.GetString2(_i)));
 }
};
 //BA.debugLineNum = 234;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 235;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 236;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _executememorytable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit) throws Exception{
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.List _table = null;
String[] _values = null;
int _col = 0;
 //BA.debugLineNum = 186;BA.debugLine="Public Sub ExecuteMemoryTable(SQL As SQL, Query As";
 //BA.debugLineNum = 187;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
 //BA.debugLineNum = 188;BA.debugLine="If StringArgs = Null Then";
if (_stringargs== null) { 
 //BA.debugLineNum = 189;BA.debugLine="Dim StringArgs(0) As String";
_stringargs = new String[(int) (0)];
java.util.Arrays.fill(_stringargs,"");
 };
 //BA.debugLineNum = 191;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
 //BA.debugLineNum = 193;BA.debugLine="Log(\"ExecuteMemoryTable: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("98978439","ExecuteMemoryTable: "+_query,0);
 //BA.debugLineNum = 195;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 196;BA.debugLine="table.Initialize";
_table.Initialize();
 //BA.debugLineNum = 197;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
 //BA.debugLineNum = 198;BA.debugLine="Dim values(cur.ColumnCount) As String";
_values = new String[_cur.getColumnCount()];
java.util.Arrays.fill(_values,"");
 //BA.debugLineNum = 199;BA.debugLine="For col = 0 To cur.ColumnCount - 1";
{
final int step11 = 1;
final int limit11 = (int) (_cur.getColumnCount()-1);
_col = (int) (0) ;
for (;_col <= limit11 ;_col = _col + step11 ) {
 //BA.debugLineNum = 200;BA.debugLine="values(col) = cur.GetString2(col)";
_values[_col] = _cur.GetString2(_col);
 }
};
 //BA.debugLineNum = 202;BA.debugLine="table.Add(values)";
_table.Add((Object)(_values));
 //BA.debugLineNum = 203;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
if (_limit>0 && _table.getSize()>=_limit) { 
if (true) break;};
 }
;
 //BA.debugLineNum = 205;BA.debugLine="cur.Close";
_cur.Close();
 //BA.debugLineNum = 206;BA.debugLine="Return table";
if (true) return _table;
 //BA.debugLineNum = 207;BA.debugLine="End Sub";
return null;
}
public static String  _executespinner(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.SpinnerWrapper _spinner1) throws Exception{
anywheresoftware.b4a.objects.collections.List _table = null;
String[] _cols = null;
int _i = 0;
 //BA.debugLineNum = 240;BA.debugLine="Sub ExecuteSpinner(SQL As SQL, Query As String, St";
 //BA.debugLineNum = 241;BA.debugLine="Spinner1.Clear";
_spinner1.Clear();
 //BA.debugLineNum = 242;BA.debugLine="Dim Table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 243;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);
 //BA.debugLineNum = 245;BA.debugLine="Dim Cols() As String";
_cols = new String[(int) (0)];
java.util.Arrays.fill(_cols,"");
 //BA.debugLineNum = 246;BA.debugLine="For i = 0 To Table.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_table.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
 //BA.debugLineNum = 247;BA.debugLine="Cols = Table.Get(i)";
_cols = (String[])(_table.Get(_i));
 //BA.debugLineNum = 248;BA.debugLine="Spinner1.Add(Cols(0))";
_spinner1.Add(_cols[(int) (0)]);
 }
};
 //BA.debugLineNum = 250;BA.debugLine="End Sub";
return "";
}
public static String  _getdbfolder(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
 //BA.debugLineNum = 39;BA.debugLine="Public Sub GetDBFolder As String";
 //BA.debugLineNum = 41;BA.debugLine="Dim rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 42;BA.debugLine="If File.ExternalWritable Then Return rp.GetSafeDi";
if (anywheresoftware.b4a.keywords.Common.File.getExternalWritable()) { 
if (true) return _rp.GetSafeDirDefaultExternal("");}
else {
if (true) return anywheresoftware.b4a.keywords.Common.File.getDirInternal();};
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static int  _getdbversion(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql) throws Exception{
int _version = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
 //BA.debugLineNum = 423;BA.debugLine="Public Sub GetDBVersion (SQL As SQL) As Int";
 //BA.debugLineNum = 424;BA.debugLine="Dim version As Int";
_version = 0;
 //BA.debugLineNum = 425;BA.debugLine="If TableExists(SQL, \"DBVersion\") Then";
if (_tableexists(_ba,_sql,"DBVersion")) { 
 //BA.debugLineNum = 426;BA.debugLine="version = SQL.ExecQuerySingleResult(\"SELECT vers";
_version = (int)(Double.parseDouble(_sql.ExecQuerySingleResult("SELECT version FROM DBVersion")));
 }else {
 //BA.debugLineNum = 432;BA.debugLine="Dim m As Map = CreateMap(\"version\": DB_INTEGER)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("version"),(Object)(_db_integer)});
 //BA.debugLineNum = 433;BA.debugLine="CreateTable(SQL, \"DBVersion\", m, \"version\")";
_createtable(_ba,_sql,"DBVersion",_m,"version");
 //BA.debugLineNum = 435;BA.debugLine="SQL.ExecNonQuery(\"INSERT INTO DBVersion VALUES (";
_sql.ExecNonQuery("INSERT INTO DBVersion VALUES (1)");
 //BA.debugLineNum = 436;BA.debugLine="version = 1";
_version = (int) (1);
 };
 //BA.debugLineNum = 438;BA.debugLine="Return version";
if (true) return _version;
 //BA.debugLineNum = 439;BA.debugLine="End Sub";
return 0;
}
public static anywheresoftware.b4a.objects.collections.List  _getfieldsinfo(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _db,String _tablename) throws Exception{
anywheresoftware.b4a.objects.collections.List _lstfieldsinfo = null;
anywheresoftware.b4a.objects.collections.List _fieldslist = null;
String[] _values = null;
com.monitorflux.dbutils._dbfieldinfo _fieldinfo = null;
 //BA.debugLineNum = 524;BA.debugLine="Public Sub GetFieldsInfo(DB As SQL, TableName As S";
 //BA.debugLineNum = 525;BA.debugLine="Dim lstFieldsInfo As List";
_lstfieldsinfo = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 526;BA.debugLine="lstFieldsInfo.Initialize";
_lstfieldsinfo.Initialize();
 //BA.debugLineNum = 527;BA.debugLine="Dim FieldsList As List = ExecuteMemoryTable(DB, \"";
_fieldslist = new anywheresoftware.b4a.objects.collections.List();
_fieldslist = _executememorytable(_ba,_db,"PRAGMA table_info ('"+_tablename+"')",(String[])(anywheresoftware.b4a.keywords.Common.Null),(int) (0));
 //BA.debugLineNum = 528;BA.debugLine="For Each values() As String In FieldsList";
{
final anywheresoftware.b4a.BA.IterableList group4 = _fieldslist;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_values = (String[])(group4.Get(index4));
 //BA.debugLineNum = 529;BA.debugLine="Dim FieldInfo As DBFieldInfo";
_fieldinfo = new com.monitorflux.dbutils._dbfieldinfo();
 //BA.debugLineNum = 530;BA.debugLine="FieldInfo.Initialize";
_fieldinfo.Initialize();
 //BA.debugLineNum = 531;BA.debugLine="FieldInfo.FieldName = values(1)";
_fieldinfo.FieldName /*String*/  = _values[(int) (1)];
 //BA.debugLineNum = 532;BA.debugLine="FieldInfo.DataType = values(2)";
_fieldinfo.DataType /*String*/  = _values[(int) (2)];
 //BA.debugLineNum = 533;BA.debugLine="FieldInfo.CanBeNull = (values(3) = 1)";
_fieldinfo.CanBeNull /*boolean*/  = ((_values[(int) (3)]).equals(BA.NumberToString(1)));
 //BA.debugLineNum = 534;BA.debugLine="FieldInfo.DefValue = values(4)";
_fieldinfo.DefValue /*Object*/  = (Object)(_values[(int) (4)]);
 //BA.debugLineNum = 535;BA.debugLine="lstFieldsInfo.Add(FieldInfo)";
_lstfieldsinfo.Add((Object)(_fieldinfo));
 }
};
 //BA.debugLineNum = 538;BA.debugLine="Return lstFieldsInfo";
if (true) return _lstfieldsinfo;
 //BA.debugLineNum = 539;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _gettables(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _db) throws Exception{
 //BA.debugLineNum = 518;BA.debugLine="Public Sub GetTables(DB As SQL) As List";
 //BA.debugLineNum = 519;BA.debugLine="Return ExecuteList(DB, \"SELECT name FROM sqlite_m";
if (true) return _executelist(_ba,_db,"SELECT name FROM sqlite_master WHERE type = 'table'",(String[])(anywheresoftware.b4a.keywords.Common.Null),(int) (0));
 //BA.debugLineNum = 520;BA.debugLine="End Sub";
return null;
}
public static boolean  _insertmaps(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.List _listofmaps) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _columns = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _values = null;
boolean _res = false;
int _i1 = 0;
anywheresoftware.b4a.objects.collections.List _listofvalues = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
String _col = "";
Object _value = null;
 //BA.debugLineNum = 131;BA.debugLine="Public Sub InsertMaps(SQL As SQL, TableName As Str";
 //BA.debugLineNum = 132;BA.debugLine="Dim sb, columns, values As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_columns = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_values = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 133;BA.debugLine="Dim res As Boolean = False";
_res = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 135;BA.debugLine="If ListOfMaps.Size > 1 And ListOfMaps.Get(0) = Li";
if (_listofmaps.getSize()>1 && (_listofmaps.Get((int) (0))).equals(_listofmaps.Get((int) (1)))) { 
 //BA.debugLineNum = 136;BA.debugLine="Log(\"Same Map found twice in list. Each item in";
anywheresoftware.b4a.keywords.Common.LogImpl("98912901","Same Map found twice in list. Each item in the list should include a different map object.",0);
 //BA.debugLineNum = 137;BA.debugLine="Return res";
if (true) return _res;
 };
 //BA.debugLineNum = 139;BA.debugLine="SQL.BeginTransaction";
_sql.BeginTransaction();
 //BA.debugLineNum = 140;BA.debugLine="Try";
try { //BA.debugLineNum = 141;BA.debugLine="For i1 = 0 To ListOfMaps.Size - 1";
{
final int step9 = 1;
final int limit9 = (int) (_listofmaps.getSize()-1);
_i1 = (int) (0) ;
for (;_i1 <= limit9 ;_i1 = _i1 + step9 ) {
 //BA.debugLineNum = 142;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 143;BA.debugLine="columns.Initialize";
_columns.Initialize();
 //BA.debugLineNum = 144;BA.debugLine="values.Initialize";
_values.Initialize();
 //BA.debugLineNum = 145;BA.debugLine="Dim listOfValues As List";
_listofvalues = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 146;BA.debugLine="listOfValues.Initialize";
_listofvalues.Initialize();
 //BA.debugLineNum = 147;BA.debugLine="sb.Append(\"INSERT INTO [\" & TableName & \"] (\")";
_sb.Append("INSERT INTO ["+_tablename+"] (");
 //BA.debugLineNum = 148;BA.debugLine="Dim m As Map = ListOfMaps.Get(i1)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_listofmaps.Get(_i1)));
 //BA.debugLineNum = 149;BA.debugLine="For Each col As String In m.Keys";
{
final anywheresoftware.b4a.BA.IterableList group17 = _m.Keys();
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_col = BA.ObjectToString(group17.Get(index17));
 //BA.debugLineNum = 150;BA.debugLine="Dim value As Object = m.Get(col)";
_value = _m.Get((Object)(_col));
 //BA.debugLineNum = 151;BA.debugLine="If listOfValues.Size > 0 Then";
if (_listofvalues.getSize()>0) { 
 //BA.debugLineNum = 152;BA.debugLine="columns.Append(\", \")";
_columns.Append(", ");
 //BA.debugLineNum = 153;BA.debugLine="values.Append(\", \")";
_values.Append(", ");
 };
 //BA.debugLineNum = 155;BA.debugLine="columns.Append(EscapeField(col))";
_columns.Append(_escapefield(_ba,_col));
 //BA.debugLineNum = 156;BA.debugLine="values.Append(\"?\")";
_values.Append("?");
 //BA.debugLineNum = 157;BA.debugLine="listOfValues.Add(value)";
_listofvalues.Add(_value);
 }
};
 //BA.debugLineNum = 159;BA.debugLine="sb.Append(columns.ToString).Append(\") VALUES (\"";
_sb.Append(_columns.ToString()).Append(") VALUES (").Append(_values.ToString()).Append(")");
 //BA.debugLineNum = 161;BA.debugLine="If i1 = 0 Then Log(\"InsertMaps (first query out";
if (_i1==0) { 
anywheresoftware.b4a.keywords.Common.LogImpl("98912926","InsertMaps (first query out of "+BA.NumberToString(_listofmaps.getSize())+"): "+_sb.ToString(),0);};
 //BA.debugLineNum = 163;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, listOfValues)";
_sql.ExecNonQuery2(_sb.ToString(),_listofvalues);
 }
};
 //BA.debugLineNum = 165;BA.debugLine="SQL.TransactionSuccessful";
_sql.TransactionSuccessful();
 //BA.debugLineNum = 166;BA.debugLine="res = True";
_res = anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34); //BA.debugLineNum = 168;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("98912933",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
 //BA.debugLineNum = 174;BA.debugLine="SQL.EndTransaction";
_sql.EndTransaction();
 //BA.debugLineNum = 176;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 177;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Type DBFieldInfo(FieldName As String, DataType As";
;
 //BA.debugLineNum = 5;BA.debugLine="Public DB_REAL, DB_INTEGER, DB_BLOB, DB_TEXT As S";
_db_real = "";
_db_integer = "";
_db_blob = "";
_db_text = "";
 //BA.debugLineNum = 6;BA.debugLine="DB_REAL = \"REAL\"";
_db_real = "REAL";
 //BA.debugLineNum = 7;BA.debugLine="DB_INTEGER = \"INTEGER\"";
_db_integer = "INTEGER";
 //BA.debugLineNum = 8;BA.debugLine="DB_BLOB = \"BLOB\"";
_db_blob = "BLOB";
 //BA.debugLineNum = 9;BA.debugLine="DB_TEXT = \"TEXT\"";
_db_text = "TEXT";
 //BA.debugLineNum = 10;BA.debugLine="Public HtmlCSS As String = $\" 		table {width: 100";
_htmlcss = ("\n"+"		table {width: 100%;border: 1px solid #cef;text-align: left; }\n"+"		th { font-weight: bold;	background-color: #acf;	border-bottom: 1px solid #cef; }\n"+"		td,th {	padding: 4px 5px; }\n"+"		.odd {background-color: #def; } \n"+"		.odd td {border-bottom: 1px solid #cef; }\n"+"		a { text-decoration:none; color: #000;}");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _setdbversion(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,int _version) throws Exception{
 //BA.debugLineNum = 444;BA.debugLine="Public Sub SetDBVersion (SQL As SQL, Version As In";
 //BA.debugLineNum = 445;BA.debugLine="SQL.ExecNonQuery2(\"UPDATE DBVersion set version =";
_sql.ExecNonQuery2("UPDATE DBVersion set version = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_version)}));
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public static boolean  _tableexists(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename) throws Exception{
int _count = 0;
 //BA.debugLineNum = 512;BA.debugLine="Public Sub TableExists(SQL As SQL, TableName As St";
 //BA.debugLineNum = 513;BA.debugLine="Dim count As Int = SQL.ExecQuerySingleResult2(\"SE";
_count = (int)(Double.parseDouble(_sql.ExecQuerySingleResult2("SELECT count(name) FROM sqlite_master WHERE type='table' AND name=? COLLATE NOCASE",new String[]{_tablename})));
 //BA.debugLineNum = 514;BA.debugLine="Return count > 0";
if (true) return _count>0;
 //BA.debugLineNum = 515;BA.debugLine="End Sub";
return false;
}
public static String  _updaterecord(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,String _field,Object _newvalue,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
 //BA.debugLineNum = 450;BA.debugLine="Public Sub UpdateRecord(SQL As SQL, TableName As S";
 //BA.debugLineNum = 452;BA.debugLine="UpdateRecord2(SQL, TableName, CreateMap(Field: Ne";
_updaterecord2(_ba,_sql,_tablename,anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)(_field),_newvalue}),_wherefieldequals);
 //BA.debugLineNum = 453;BA.debugLine="End Sub";
return "";
}
public static String  _updaterecord2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _fields,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
String _col = "";
 //BA.debugLineNum = 457;BA.debugLine="Public Sub UpdateRecord2(SQL As SQL, TableName As";
 //BA.debugLineNum = 458;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
if (_wherefieldequals.getSize()==0) { 
 //BA.debugLineNum = 459;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("99699330","WhereFieldEquals map empty!",0);
 //BA.debugLineNum = 460;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 462;BA.debugLine="If Fields.Size = 0 Then";
if (_fields.getSize()==0) { 
 //BA.debugLineNum = 463;BA.debugLine="Log(\"Fields empty\")";
anywheresoftware.b4a.keywords.Common.LogImpl("99699334","Fields empty",0);
 //BA.debugLineNum = 464;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 466;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 467;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 468;BA.debugLine="sb.Append(\"UPDATE \").Append(EscapeField(TableName";
_sb.Append("UPDATE ").Append(_escapefield(_ba,_tablename)).Append(" SET ");
 //BA.debugLineNum = 469;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 470;BA.debugLine="args.Initialize";
_args.Initialize();
 //BA.debugLineNum = 471;BA.debugLine="For Each col As String In Fields.Keys";
{
final anywheresoftware.b4a.BA.IterableList group14 = _fields.Keys();
final int groupLen14 = group14.getSize()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_col = BA.ObjectToString(group14.Get(index14));
 //BA.debugLineNum = 472;BA.debugLine="sb.Append(EscapeField(col)).Append(\"=?\")";
_sb.Append(_escapefield(_ba,_col)).Append("=?");
 //BA.debugLineNum = 473;BA.debugLine="sb.Append(\",\")";
_sb.Append(",");
 //BA.debugLineNum = 474;BA.debugLine="args.Add(Fields.Get(col))";
_args.Add(_fields.Get((Object)(_col)));
 }
};
 //BA.debugLineNum = 476;BA.debugLine="sb.Remove(sb.Length - 1, sb.Length)";
_sb.Remove((int) (_sb.getLength()-1),_sb.getLength());
 //BA.debugLineNum = 477;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
 //BA.debugLineNum = 478;BA.debugLine="For Each col As String In WhereFieldEquals.Keys";
{
final anywheresoftware.b4a.BA.IterableList group21 = _wherefieldequals.Keys();
final int groupLen21 = group21.getSize()
;int index21 = 0;
;
for (; index21 < groupLen21;index21++){
_col = BA.ObjectToString(group21.Get(index21));
 //BA.debugLineNum = 479;BA.debugLine="sb.Append(EscapeField(col)).Append(\" = ?\")";
_sb.Append(_escapefield(_ba,_col)).Append(" = ?");
 //BA.debugLineNum = 480;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
 //BA.debugLineNum = 481;BA.debugLine="args.Add(WhereFieldEquals.Get(col))";
_args.Add(_wherefieldequals.Get((Object)(_col)));
 }
};
 //BA.debugLineNum = 483;BA.debugLine="sb.Remove(sb.Length - \" AND \".Length, sb.Length)";
_sb.Remove((int) (_sb.getLength()-" AND ".length()),_sb.getLength());
 //BA.debugLineNum = 484;BA.debugLine="Log(\"UpdateRecord: \" & sb.ToString)";
anywheresoftware.b4a.keywords.Common.LogImpl("99699355","UpdateRecord: "+_sb.ToString(),0);
 //BA.debugLineNum = 485;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
_sql.ExecNonQuery2(_sb.ToString(),_args);
 //BA.debugLineNum = 486;BA.debugLine="End Sub";
return "";
}
}
