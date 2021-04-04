package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class dbutils {
private static dbutils mostCurrent = new dbutils();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
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
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _db_real = "";
public static String _db_integer = "";
public static String _db_blob = "";
public static String _db_text = "";
public static String _htmlcss = "";
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.tutoriales_activity _tutoriales_activity = null;
public b4a.example.agregar_activity _agregar_activity = null;
public b4a.example.monitor_activity _monitor_activity = null;
public b4a.example.datos_activity _datos_activity = null;
public b4a.example.registrar_activity _registrar_activity = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _copydbfromassets(anywheresoftware.b4a.BA _ba,String _filename) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "copydbfromassets", true))
	 {return ((String) Debug.delegate(null, "copydbfromassets", new Object[] {_ba,_filename}));}
String _targetdir = "";
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Public Sub CopyDBFromAssets (FileName As String) A";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="Dim TargetDir As String = GetDBFolder";
_targetdir = _getdbfolder(_ba);
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="If File.Exists(TargetDir, FileName) = False Then";
if (anywheresoftware.b4a.keywords.Common.File.Exists(_targetdir,_filename)==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="File.Copy(File.DirAssets, FileName, TargetDir, F";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_filename,_targetdir,_filename);
 };
RDebugUtils.currentLine=8323077;
 //BA.debugLineNum = 8323077;BA.debugLine="Return TargetDir";
if (true) return _targetdir;
RDebugUtils.currentLine=8323078;
 //BA.debugLineNum = 8323078;BA.debugLine="End Sub";
return "";
}
public static String  _getdbfolder(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "getdbfolder", true))
	 {return ((String) Debug.delegate(null, "getdbfolder", new Object[] {_ba}));}
anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Public Sub GetDBFolder As String";
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="Dim rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="If File.ExternalWritable Then Return rp.GetSafeDi";
if (anywheresoftware.b4a.keywords.Common.File.getExternalWritable()) { 
if (true) return _rp.GetSafeDirDefaultExternal("");}
else {
if (true) return anywheresoftware.b4a.keywords.Common.File.getDirInternal();};
RDebugUtils.currentLine=8257543;
 //BA.debugLineNum = 8257543;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _executemap(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executemap", true))
	 {return ((anywheresoftware.b4a.objects.collections.Map) Debug.delegate(null, "executemap", new Object[] {_ba,_sql,_query,_stringargs}));}
anywheresoftware.b4a.objects.collections.Map _res = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
int _i = 0;
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Public Sub ExecuteMap(SQL As SQL, Query As String,";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="Dim res As Map";
_res = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
RDebugUtils.currentLine=8716291;
 //BA.debugLineNum = 8716291;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
RDebugUtils.currentLine=8716292;
 //BA.debugLineNum = 8716292;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
 }else {
RDebugUtils.currentLine=8716294;
 //BA.debugLineNum = 8716294;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery(_query)));
 };
RDebugUtils.currentLine=8716297;
 //BA.debugLineNum = 8716297;BA.debugLine="Log(\"ExecuteMap: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("98716297","ExecuteMap: "+_query,0);
RDebugUtils.currentLine=8716299;
 //BA.debugLineNum = 8716299;BA.debugLine="If cur.NextRow = False Then";
if (_cur.NextRow()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8716301;
 //BA.debugLineNum = 8716301;BA.debugLine="Log(\"No records found.\")";
anywheresoftware.b4a.keywords.Common.LogImpl("98716301","No records found.",0);
RDebugUtils.currentLine=8716303;
 //BA.debugLineNum = 8716303;BA.debugLine="Return res";
if (true) return _res;
 };
RDebugUtils.currentLine=8716305;
 //BA.debugLineNum = 8716305;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=8716306;
 //BA.debugLineNum = 8716306;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step14 = 1;
final int limit14 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
RDebugUtils.currentLine=8716307;
 //BA.debugLineNum = 8716307;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.Ge";
_res.Put((Object)(_cur.GetColumnName(_i).toLowerCase()),(Object)(_cur.GetString2(_i)));
 }
};
RDebugUtils.currentLine=8716309;
 //BA.debugLineNum = 8716309;BA.debugLine="cur.Close";
_cur.Close();
RDebugUtils.currentLine=8716310;
 //BA.debugLineNum = 8716310;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8716311;
 //BA.debugLineNum = 8716311;BA.debugLine="End Sub";
return null;
}
public static String  _createtable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _fieldsandtypes,String _primarykey) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "createtable", true))
	 {return ((String) Debug.delegate(null, "createtable", new Object[] {_ba,_sql,_tablename,_fieldsandtypes,_primarykey}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
String _field = "";
String _ftype = "";
String _query = "";
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Public Sub CreateTable(SQL As SQL, TableName As St";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="sb.Append(\"(\")";
_sb.Append("(");
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="For i = 0 To FieldsAndTypes.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (_fieldsandtypes.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=8454149;
 //BA.debugLineNum = 8454149;BA.debugLine="Dim field, ftype As String";
_field = "";
_ftype = "";
RDebugUtils.currentLine=8454150;
 //BA.debugLineNum = 8454150;BA.debugLine="field = FieldsAndTypes.GetKeyAt(i)";
_field = BA.ObjectToString(_fieldsandtypes.GetKeyAt(_i));
RDebugUtils.currentLine=8454151;
 //BA.debugLineNum = 8454151;BA.debugLine="ftype = FieldsAndTypes.GetValueAt(i)";
_ftype = BA.ObjectToString(_fieldsandtypes.GetValueAt(_i));
RDebugUtils.currentLine=8454152;
 //BA.debugLineNum = 8454152;BA.debugLine="If i > 0 Then sb.Append(\", \")";
if (_i>0) { 
_sb.Append(", ");};
RDebugUtils.currentLine=8454153;
 //BA.debugLineNum = 8454153;BA.debugLine="sb.Append(EscapeField(field)).Append(\" \").Append";
_sb.Append(_escapefield(_ba,_field)).Append(" ").Append(_ftype);
RDebugUtils.currentLine=8454154;
 //BA.debugLineNum = 8454154;BA.debugLine="If field = PrimaryKey Then sb.Append(\" PRIMARY K";
if ((_field).equals(_primarykey)) { 
_sb.Append(" PRIMARY KEY");};
 }
};
RDebugUtils.currentLine=8454156;
 //BA.debugLineNum = 8454156;BA.debugLine="sb.Append(\")\")";
_sb.Append(")");
RDebugUtils.currentLine=8454157;
 //BA.debugLineNum = 8454157;BA.debugLine="Dim query As String = \"CREATE TABLE IF NOT EXISTS";
_query = "CREATE TABLE IF NOT EXISTS "+_escapefield(_ba,_tablename)+" "+_sb.ToString();
RDebugUtils.currentLine=8454159;
 //BA.debugLineNum = 8454159;BA.debugLine="Log(\"CreateTable: \" & query)";
anywheresoftware.b4a.keywords.Common.LogImpl("98454159","CreateTable: "+_query,0);
RDebugUtils.currentLine=8454161;
 //BA.debugLineNum = 8454161;BA.debugLine="SQL.ExecNonQuery(query)";
_sql.ExecNonQuery(_query);
RDebugUtils.currentLine=8454162;
 //BA.debugLineNum = 8454162;BA.debugLine="End Sub";
return "";
}
public static String  _escapefield(anywheresoftware.b4a.BA _ba,String _f) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "escapefield", true))
	 {return ((String) Debug.delegate(null, "escapefield", new Object[] {_ba,_f}));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Private Sub EscapeField(f As String) As String";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="Return \"[\" & f & \"]\"";
if (true) return "["+_f+"]";
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="End Sub";
return "";
}
public static String  _deleterecord(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "deleterecord", true))
	 {return ((String) Debug.delegate(null, "deleterecord", new Object[] {_ba,_sql,_tablename,_wherefieldequals}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
String _col = "";
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Public Sub DeleteRecord(SQL As SQL, TableName As S";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=9437187;
 //BA.debugLineNum = 9437187;BA.debugLine="sb.Append(\"DELETE FROM \" & EscapeField(TableName)";
_sb.Append("DELETE FROM "+_escapefield(_ba,_tablename)+" WHERE ");
RDebugUtils.currentLine=9437188;
 //BA.debugLineNum = 9437188;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
if (_wherefieldequals.getSize()==0) { 
RDebugUtils.currentLine=9437189;
 //BA.debugLineNum = 9437189;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("99437189","WhereFieldEquals map empty!",0);
RDebugUtils.currentLine=9437190;
 //BA.debugLineNum = 9437190;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=9437192;
 //BA.debugLineNum = 9437192;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9437193;
 //BA.debugLineNum = 9437193;BA.debugLine="args.Initialize";
_args.Initialize();
RDebugUtils.currentLine=9437194;
 //BA.debugLineNum = 9437194;BA.debugLine="For Each col As String In WhereFieldEquals.Keys";
{
final anywheresoftware.b4a.BA.IterableList group10 = _wherefieldequals.Keys();
final int groupLen10 = group10.getSize()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_col = BA.ObjectToString(group10.Get(index10));
RDebugUtils.currentLine=9437195;
 //BA.debugLineNum = 9437195;BA.debugLine="If args.Size > 0 Then sb.Append(\" AND \")";
if (_args.getSize()>0) { 
_sb.Append(" AND ");};
RDebugUtils.currentLine=9437196;
 //BA.debugLineNum = 9437196;BA.debugLine="sb.Append(EscapeField(col)).Append(\" = ?\")";
_sb.Append(_escapefield(_ba,_col)).Append(" = ?");
RDebugUtils.currentLine=9437197;
 //BA.debugLineNum = 9437197;BA.debugLine="args.Add(WhereFieldEquals.Get(col))";
_args.Add(_wherefieldequals.Get((Object)(_col)));
 }
};
RDebugUtils.currentLine=9437200;
 //BA.debugLineNum = 9437200;BA.debugLine="Log(\"DeleteRecord: \" & sb.ToString)";
anywheresoftware.b4a.keywords.Common.LogImpl("99437200","DeleteRecord: "+_sb.ToString(),0);
RDebugUtils.currentLine=9437202;
 //BA.debugLineNum = 9437202;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
_sql.ExecNonQuery2(_sb.ToString(),_args);
RDebugUtils.currentLine=9437203;
 //BA.debugLineNum = 9437203;BA.debugLine="End Sub";
return "";
}
public static String  _droptable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "droptable", true))
	 {return ((String) Debug.delegate(null, "droptable", new Object[] {_ba,_sql,_tablename}));}
String _query = "";
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Public Sub DropTable(SQL As SQL, TableName As Stri";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="Dim query As String = \"DROP TABLE IF EXISTS\" & Es";
_query = "DROP TABLE IF EXISTS"+_escapefield(_ba,_tablename);
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="Log(\"DropTable: \" & query)";
anywheresoftware.b4a.keywords.Common.LogImpl("98519683","DropTable: "+_query,0);
RDebugUtils.currentLine=8519685;
 //BA.debugLineNum = 8519685;BA.debugLine="SQL.ExecNonQuery(query)";
_sql.ExecNonQuery(_query);
RDebugUtils.currentLine=8519686;
 //BA.debugLineNum = 8519686;BA.debugLine="End Sub";
return "";
}
public static String  _executehtml(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,boolean _clickable) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executehtml", true))
	 {return ((String) Debug.delegate(null, "executehtml", new Object[] {_ba,_sql,_query,_stringargs,_limit,_clickable}));}
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
int _i = 0;
int _row = 0;
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Public Sub ExecuteHtml(SQL As SQL, Query As String";
RDebugUtils.currentLine=9109505;
 //BA.debugLineNum = 9109505;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
RDebugUtils.currentLine=9109507;
 //BA.debugLineNum = 9109507;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
 }else {
RDebugUtils.currentLine=9109509;
 //BA.debugLineNum = 9109509;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery(_query)));
 };
RDebugUtils.currentLine=9109512;
 //BA.debugLineNum = 9109512;BA.debugLine="Log(\"ExecuteHtml: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("99109512","ExecuteHtml: "+_query,0);
RDebugUtils.currentLine=9109515;
 //BA.debugLineNum = 9109515;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=9109516;
 //BA.debugLineNum = 9109516;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=9109517;
 //BA.debugLineNum = 9109517;BA.debugLine="sb.Append(\"<html><body>\").Append(CRLF)";
_sb.Append("<html><body>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=9109518;
 //BA.debugLineNum = 9109518;BA.debugLine="sb.Append(\"<style type='text/css'>\").Append(HtmlC";
_sb.Append("<style type='text/css'>").Append(_htmlcss).Append("</style>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=9109519;
 //BA.debugLineNum = 9109519;BA.debugLine="sb.Append(\"<table><thead><tr>\").Append(CRLF)";
_sb.Append("<table><thead><tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=9109520;
 //BA.debugLineNum = 9109520;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step13 = 1;
final int limit13 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit13 ;_i = _i + step13 ) {
RDebugUtils.currentLine=9109521;
 //BA.debugLineNum = 9109521;BA.debugLine="sb.Append(\"<th>\").Append(cur.GetColumnName(i)).A";
_sb.Append("<th>").Append(_cur.GetColumnName(_i)).Append("</th>");
 }
};
RDebugUtils.currentLine=9109523;
 //BA.debugLineNum = 9109523;BA.debugLine="sb.Append(\"</thead>\")";
_sb.Append("</thead>");
RDebugUtils.currentLine=9109533;
 //BA.debugLineNum = 9109533;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
_sb.Append("</tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=9109534;
 //BA.debugLineNum = 9109534;BA.debugLine="Dim row As Int";
_row = 0;
RDebugUtils.currentLine=9109535;
 //BA.debugLineNum = 9109535;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
RDebugUtils.currentLine=9109536;
 //BA.debugLineNum = 9109536;BA.debugLine="If row Mod 2 = 0 Then";
if (_row%2==0) { 
RDebugUtils.currentLine=9109537;
 //BA.debugLineNum = 9109537;BA.debugLine="sb.Append(\"<tr>\")";
_sb.Append("<tr>");
 }else {
RDebugUtils.currentLine=9109539;
 //BA.debugLineNum = 9109539;BA.debugLine="sb.Append(\"<tr class='odd'>\")";
_sb.Append("<tr class='odd'>");
 };
RDebugUtils.currentLine=9109541;
 //BA.debugLineNum = 9109541;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step25 = 1;
final int limit25 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit25 ;_i = _i + step25 ) {
RDebugUtils.currentLine=9109542;
 //BA.debugLineNum = 9109542;BA.debugLine="sb.Append(\"<td>\")";
_sb.Append("<td>");
RDebugUtils.currentLine=9109543;
 //BA.debugLineNum = 9109543;BA.debugLine="If Clickable Then";
if (_clickable) { 
RDebugUtils.currentLine=9109544;
 //BA.debugLineNum = 9109544;BA.debugLine="sb.Append(\"<a href='http://\").Append(i).Append";
_sb.Append("<a href='http://").Append(BA.NumberToString(_i)).Append(".");
RDebugUtils.currentLine=9109545;
 //BA.debugLineNum = 9109545;BA.debugLine="sb.Append(row)";
_sb.Append(BA.NumberToString(_row));
RDebugUtils.currentLine=9109546;
 //BA.debugLineNum = 9109546;BA.debugLine="sb.Append(\".stub'>\").Append(cur.GetString2(i))";
_sb.Append(".stub'>").Append(_cur.GetString2(_i)).Append("</a>");
 }else {
RDebugUtils.currentLine=9109548;
 //BA.debugLineNum = 9109548;BA.debugLine="sb.Append(cur.GetString2(i))";
_sb.Append(_cur.GetString2(_i));
 };
RDebugUtils.currentLine=9109550;
 //BA.debugLineNum = 9109550;BA.debugLine="sb.Append(\"</td>\")";
_sb.Append("</td>");
 }
};
RDebugUtils.currentLine=9109552;
 //BA.debugLineNum = 9109552;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
_sb.Append("</tr>").Append(anywheresoftware.b4a.keywords.Common.CRLF);
RDebugUtils.currentLine=9109553;
 //BA.debugLineNum = 9109553;BA.debugLine="row = row + 1";
_row = (int) (_row+1);
 }
;
RDebugUtils.currentLine=9109555;
 //BA.debugLineNum = 9109555;BA.debugLine="cur.Close";
_cur.Close();
RDebugUtils.currentLine=9109556;
 //BA.debugLineNum = 9109556;BA.debugLine="sb.Append(\"</table></body></html>\")";
_sb.Append("</table></body></html>");
RDebugUtils.currentLine=9109557;
 //BA.debugLineNum = 9109557;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
RDebugUtils.currentLine=9109558;
 //BA.debugLineNum = 9109558;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.collections.Map  _executejson(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.collections.List _dbtypes) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executejson", true))
	 {return ((anywheresoftware.b4a.objects.collections.Map) Debug.delegate(null, "executejson", new Object[] {_ba,_sql,_query,_stringargs,_limit,_dbtypes}));}
anywheresoftware.b4a.objects.collections.List _table = null;
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i = 0;
anywheresoftware.b4a.objects.collections.Map _root = null;
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Public Sub ExecuteJSON (SQL As SQL, Query As Strin";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
RDebugUtils.currentLine=9043971;
 //BA.debugLineNum = 9043971;BA.debugLine="If StringArgs <> Null Then";
if (_stringargs!= null) { 
RDebugUtils.currentLine=9043972;
 //BA.debugLineNum = 9043972;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
 }else {
RDebugUtils.currentLine=9043974;
 //BA.debugLineNum = 9043974;BA.debugLine="cur = SQL.ExecQuery(Query)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery(_query)));
 };
RDebugUtils.currentLine=9043977;
 //BA.debugLineNum = 9043977;BA.debugLine="Log(\"ExecuteJSON: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("99043977","ExecuteJSON: "+_query,0);
RDebugUtils.currentLine=9043979;
 //BA.debugLineNum = 9043979;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9043980;
 //BA.debugLineNum = 9043980;BA.debugLine="table.Initialize";
_table.Initialize();
RDebugUtils.currentLine=9043981;
 //BA.debugLineNum = 9043981;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
RDebugUtils.currentLine=9043982;
 //BA.debugLineNum = 9043982;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=9043983;
 //BA.debugLineNum = 9043983;BA.debugLine="m.Initialize";
_m.Initialize();
RDebugUtils.currentLine=9043984;
 //BA.debugLineNum = 9043984;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
{
final int step14 = 1;
final int limit14 = (int) (_cur.getColumnCount()-1);
_i = (int) (0) ;
for (;_i <= limit14 ;_i = _i + step14 ) {
RDebugUtils.currentLine=9043985;
 //BA.debugLineNum = 9043985;BA.debugLine="Select DBTypes.Get(i)";
switch (BA.switchObjectToInt(_dbtypes.Get(_i),(Object)(_db_text),(Object)(_db_integer),(Object)(_db_real))) {
case 0: {
RDebugUtils.currentLine=9043987;
 //BA.debugLineNum = 9043987;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetString2(i)";
_m.Put((Object)(_cur.GetColumnName(_i)),(Object)(_cur.GetString2(_i)));
 break; }
case 1: {
RDebugUtils.currentLine=9043989;
 //BA.debugLineNum = 9043989;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetLong2(i))";
_m.Put((Object)(_cur.GetColumnName(_i)),(Object)(_cur.GetLong2(_i)));
 break; }
case 2: {
RDebugUtils.currentLine=9043991;
 //BA.debugLineNum = 9043991;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetDouble2(i)";
_m.Put((Object)(_cur.GetColumnName(_i)),(Object)(_cur.GetDouble2(_i)));
 break; }
default: {
RDebugUtils.currentLine=9043993;
 //BA.debugLineNum = 9043993;BA.debugLine="Log(\"Invalid type: \" & DBTypes.Get(i))";
anywheresoftware.b4a.keywords.Common.LogImpl("99043993","Invalid type: "+BA.ObjectToString(_dbtypes.Get(_i)),0);
 break; }
}
;
 }
};
RDebugUtils.currentLine=9043996;
 //BA.debugLineNum = 9043996;BA.debugLine="table.Add(m)";
_table.Add((Object)(_m.getObject()));
RDebugUtils.currentLine=9043997;
 //BA.debugLineNum = 9043997;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
if (_limit>0 && _table.getSize()>=_limit) { 
if (true) break;};
 }
;
RDebugUtils.currentLine=9043999;
 //BA.debugLineNum = 9043999;BA.debugLine="cur.Close";
_cur.Close();
RDebugUtils.currentLine=9044000;
 //BA.debugLineNum = 9044000;BA.debugLine="Dim root As Map";
_root = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=9044001;
 //BA.debugLineNum = 9044001;BA.debugLine="root.Initialize";
_root.Initialize();
RDebugUtils.currentLine=9044002;
 //BA.debugLineNum = 9044002;BA.debugLine="root.Put(\"root\", table)";
_root.Put((Object)("root"),(Object)(_table.getObject()));
RDebugUtils.currentLine=9044003;
 //BA.debugLineNum = 9044003;BA.debugLine="Return root";
if (true) return _root;
RDebugUtils.currentLine=9044004;
 //BA.debugLineNum = 9044004;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _executelist(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executelist", true))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "executelist", new Object[] {_ba,_sql,_query,_stringargs,_limit}));}
anywheresoftware.b4a.objects.collections.List _table = null;
anywheresoftware.b4a.objects.collections.List _res = null;
String[] _cols = null;
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Public Sub ExecuteList(SQL As SQL, Query As String";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="Dim Table As List = ExecuteMemoryTable(SQL, Query";
_table = new anywheresoftware.b4a.objects.collections.List();
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8978435;
 //BA.debugLineNum = 8978435;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=8978436;
 //BA.debugLineNum = 8978436;BA.debugLine="For Each Cols() As String In Table";
{
final anywheresoftware.b4a.BA.IterableList group4 = _table;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_cols = (String[])(group4.Get(index4));
RDebugUtils.currentLine=8978437;
 //BA.debugLineNum = 8978437;BA.debugLine="res.Add(Cols(0))";
_res.Add((Object)(_cols[(int) (0)]));
 }
};
RDebugUtils.currentLine=8978439;
 //BA.debugLineNum = 8978439;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8978440;
 //BA.debugLineNum = 8978440;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _executememorytable(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executememorytable", true))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "executememorytable", new Object[] {_ba,_sql,_query,_stringargs,_limit}));}
anywheresoftware.b4a.sql.SQL.ResultSetWrapper _cur = null;
anywheresoftware.b4a.objects.collections.List _table = null;
String[] _values = null;
int _col = 0;
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Public Sub ExecuteMemoryTable(SQL As SQL, Query As";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="Dim cur As ResultSet";
_cur = new anywheresoftware.b4a.sql.SQL.ResultSetWrapper();
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="If StringArgs = Null Then";
if (_stringargs== null) { 
RDebugUtils.currentLine=8650755;
 //BA.debugLineNum = 8650755;BA.debugLine="Dim StringArgs(0) As String";
_stringargs = new String[(int) (0)];
java.util.Arrays.fill(_stringargs,"");
 };
RDebugUtils.currentLine=8650757;
 //BA.debugLineNum = 8650757;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
_cur = (anywheresoftware.b4a.sql.SQL.ResultSetWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.ResultSetWrapper(), (android.database.Cursor)(_sql.ExecQuery2(_query,_stringargs)));
RDebugUtils.currentLine=8650759;
 //BA.debugLineNum = 8650759;BA.debugLine="Log(\"ExecuteMemoryTable: \" & Query)";
anywheresoftware.b4a.keywords.Common.LogImpl("98650759","ExecuteMemoryTable: "+_query,0);
RDebugUtils.currentLine=8650761;
 //BA.debugLineNum = 8650761;BA.debugLine="Dim table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8650762;
 //BA.debugLineNum = 8650762;BA.debugLine="table.Initialize";
_table.Initialize();
RDebugUtils.currentLine=8650763;
 //BA.debugLineNum = 8650763;BA.debugLine="Do While cur.NextRow";
while (_cur.NextRow()) {
RDebugUtils.currentLine=8650764;
 //BA.debugLineNum = 8650764;BA.debugLine="Dim values(cur.ColumnCount) As String";
_values = new String[_cur.getColumnCount()];
java.util.Arrays.fill(_values,"");
RDebugUtils.currentLine=8650765;
 //BA.debugLineNum = 8650765;BA.debugLine="For col = 0 To cur.ColumnCount - 1";
{
final int step11 = 1;
final int limit11 = (int) (_cur.getColumnCount()-1);
_col = (int) (0) ;
for (;_col <= limit11 ;_col = _col + step11 ) {
RDebugUtils.currentLine=8650766;
 //BA.debugLineNum = 8650766;BA.debugLine="values(col) = cur.GetString2(col)";
_values[_col] = _cur.GetString2(_col);
 }
};
RDebugUtils.currentLine=8650768;
 //BA.debugLineNum = 8650768;BA.debugLine="table.Add(values)";
_table.Add((Object)(_values));
RDebugUtils.currentLine=8650769;
 //BA.debugLineNum = 8650769;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
if (_limit>0 && _table.getSize()>=_limit) { 
if (true) break;};
 }
;
RDebugUtils.currentLine=8650771;
 //BA.debugLineNum = 8650771;BA.debugLine="cur.Close";
_cur.Close();
RDebugUtils.currentLine=8650772;
 //BA.debugLineNum = 8650772;BA.debugLine="Return table";
if (true) return _table;
RDebugUtils.currentLine=8650773;
 //BA.debugLineNum = 8650773;BA.debugLine="End Sub";
return null;
}
public static String  _executelist2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.collections.List _list) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executelist2", true))
	 {return ((String) Debug.delegate(null, "executelist2", new Object[] {_ba,_sql,_query,_stringargs,_limit,_list}));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Public Sub ExecuteList2(SQL As SQL, Query As Strin";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="List.Clear";
_list.Clear();
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="List.AddAll(ExecuteList(SQL, Query, StringArgs, L";
_list.AddAll(_executelist(_ba,_sql,_query,_stringargs,_limit));
RDebugUtils.currentLine=8912899;
 //BA.debugLineNum = 8912899;BA.debugLine="End Sub";
return "";
}
public static String  _executelistview(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.ListViewWrapper _listview1,boolean _twolines) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executelistview", true))
	 {return ((String) Debug.delegate(null, "executelistview", new Object[] {_ba,_sql,_query,_stringargs,_limit,_listview1,_twolines}));}
anywheresoftware.b4a.objects.collections.List _table = null;
String[] _cols = null;
int _i = 0;
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Public Sub ExecuteListView(SQL As SQL, Query As St";
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="ListView1.Clear";
_listview1.Clear();
RDebugUtils.currentLine=8847363;
 //BA.debugLineNum = 8847363;BA.debugLine="Dim Table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8847364;
 //BA.debugLineNum = 8847364;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);
RDebugUtils.currentLine=8847365;
 //BA.debugLineNum = 8847365;BA.debugLine="Dim Cols() As String";
_cols = new String[(int) (0)];
java.util.Arrays.fill(_cols,"");
RDebugUtils.currentLine=8847366;
 //BA.debugLineNum = 8847366;BA.debugLine="For i = 0 To Table.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_table.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=8847367;
 //BA.debugLineNum = 8847367;BA.debugLine="Cols = Table.Get(i)";
_cols = (String[])(_table.Get(_i));
RDebugUtils.currentLine=8847368;
 //BA.debugLineNum = 8847368;BA.debugLine="If TwoLines Then";
if (_twolines) { 
RDebugUtils.currentLine=8847369;
 //BA.debugLineNum = 8847369;BA.debugLine="ListView1.AddTwoLines2(Cols(0), Cols(1), Cols)";
_listview1.AddTwoLines2(BA.ObjectToCharSequence(_cols[(int) (0)]),BA.ObjectToCharSequence(_cols[(int) (1)]),(Object)(_cols));
 }else {
RDebugUtils.currentLine=8847371;
 //BA.debugLineNum = 8847371;BA.debugLine="ListView1.AddSingleLine2(Cols(0), Cols)";
_listview1.AddSingleLine2(BA.ObjectToCharSequence(_cols[(int) (0)]),(Object)(_cols));
 };
 }
};
RDebugUtils.currentLine=8847374;
 //BA.debugLineNum = 8847374;BA.debugLine="End Sub";
return "";
}
public static String  _executespinner(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _query,String[] _stringargs,int _limit,anywheresoftware.b4a.objects.SpinnerWrapper _spinner1) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "executespinner", true))
	 {return ((String) Debug.delegate(null, "executespinner", new Object[] {_ba,_sql,_query,_stringargs,_limit,_spinner1}));}
anywheresoftware.b4a.objects.collections.List _table = null;
String[] _cols = null;
int _i = 0;
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Sub ExecuteSpinner(SQL As SQL, Query As String, St";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="Spinner1.Clear";
_spinner1.Clear();
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="Dim Table As List";
_table = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8781827;
 //BA.debugLineNum = 8781827;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);
RDebugUtils.currentLine=8781829;
 //BA.debugLineNum = 8781829;BA.debugLine="Dim Cols() As String";
_cols = new String[(int) (0)];
java.util.Arrays.fill(_cols,"");
RDebugUtils.currentLine=8781830;
 //BA.debugLineNum = 8781830;BA.debugLine="For i = 0 To Table.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_table.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=8781831;
 //BA.debugLineNum = 8781831;BA.debugLine="Cols = Table.Get(i)";
_cols = (String[])(_table.Get(_i));
RDebugUtils.currentLine=8781832;
 //BA.debugLineNum = 8781832;BA.debugLine="Spinner1.Add(Cols(0))";
_spinner1.Add(_cols[(int) (0)]);
 }
};
RDebugUtils.currentLine=8781834;
 //BA.debugLineNum = 8781834;BA.debugLine="End Sub";
return "";
}
public static int  _getdbversion(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "getdbversion", true))
	 {return ((Integer) Debug.delegate(null, "getdbversion", new Object[] {_ba,_sql}));}
int _version = 0;
anywheresoftware.b4a.objects.collections.Map _m = null;
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Public Sub GetDBVersion (SQL As SQL) As Int";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="Dim version As Int";
_version = 0;
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="If TableExists(SQL, \"DBVersion\") Then";
if (_tableexists(_ba,_sql,"DBVersion")) { 
RDebugUtils.currentLine=9175043;
 //BA.debugLineNum = 9175043;BA.debugLine="version = SQL.ExecQuerySingleResult(\"SELECT vers";
_version = (int)(Double.parseDouble(_sql.ExecQuerySingleResult("SELECT version FROM DBVersion")));
 }else {
RDebugUtils.currentLine=9175049;
 //BA.debugLineNum = 9175049;BA.debugLine="Dim m As Map = CreateMap(\"version\": DB_INTEGER)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)("version"),(Object)(_db_integer)});
RDebugUtils.currentLine=9175050;
 //BA.debugLineNum = 9175050;BA.debugLine="CreateTable(SQL, \"DBVersion\", m, \"version\")";
_createtable(_ba,_sql,"DBVersion",_m,"version");
RDebugUtils.currentLine=9175052;
 //BA.debugLineNum = 9175052;BA.debugLine="SQL.ExecNonQuery(\"INSERT INTO DBVersion VALUES (";
_sql.ExecNonQuery("INSERT INTO DBVersion VALUES (1)");
RDebugUtils.currentLine=9175053;
 //BA.debugLineNum = 9175053;BA.debugLine="version = 1";
_version = (int) (1);
 };
RDebugUtils.currentLine=9175055;
 //BA.debugLineNum = 9175055;BA.debugLine="Return version";
if (true) return _version;
RDebugUtils.currentLine=9175056;
 //BA.debugLineNum = 9175056;BA.debugLine="End Sub";
return 0;
}
public static boolean  _tableexists(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "tableexists", true))
	 {return ((Boolean) Debug.delegate(null, "tableexists", new Object[] {_ba,_sql,_tablename}));}
int _count = 0;
RDebugUtils.currentLine=9502720;
 //BA.debugLineNum = 9502720;BA.debugLine="Public Sub TableExists(SQL As SQL, TableName As St";
RDebugUtils.currentLine=9502721;
 //BA.debugLineNum = 9502721;BA.debugLine="Dim count As Int = SQL.ExecQuerySingleResult2(\"SE";
_count = (int)(Double.parseDouble(_sql.ExecQuerySingleResult2("SELECT count(name) FROM sqlite_master WHERE type='table' AND name=? COLLATE NOCASE",new String[]{_tablename})));
RDebugUtils.currentLine=9502722;
 //BA.debugLineNum = 9502722;BA.debugLine="Return count > 0";
if (true) return _count>0;
RDebugUtils.currentLine=9502723;
 //BA.debugLineNum = 9502723;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.List  _getfieldsinfo(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _db,String _tablename) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "getfieldsinfo", true))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "getfieldsinfo", new Object[] {_ba,_db,_tablename}));}
anywheresoftware.b4a.objects.collections.List _lstfieldsinfo = null;
anywheresoftware.b4a.objects.collections.List _fieldslist = null;
String[] _values = null;
b4a.example.dbutils._dbfieldinfo _fieldinfo = null;
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Public Sub GetFieldsInfo(DB As SQL, TableName As S";
RDebugUtils.currentLine=9633793;
 //BA.debugLineNum = 9633793;BA.debugLine="Dim lstFieldsInfo As List";
_lstfieldsinfo = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9633794;
 //BA.debugLineNum = 9633794;BA.debugLine="lstFieldsInfo.Initialize";
_lstfieldsinfo.Initialize();
RDebugUtils.currentLine=9633795;
 //BA.debugLineNum = 9633795;BA.debugLine="Dim FieldsList As List = ExecuteMemoryTable(DB, \"";
_fieldslist = new anywheresoftware.b4a.objects.collections.List();
_fieldslist = _executememorytable(_ba,_db,"PRAGMA table_info ('"+_tablename+"')",(String[])(anywheresoftware.b4a.keywords.Common.Null),(int) (0));
RDebugUtils.currentLine=9633796;
 //BA.debugLineNum = 9633796;BA.debugLine="For Each values() As String In FieldsList";
{
final anywheresoftware.b4a.BA.IterableList group4 = _fieldslist;
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_values = (String[])(group4.Get(index4));
RDebugUtils.currentLine=9633797;
 //BA.debugLineNum = 9633797;BA.debugLine="Dim FieldInfo As DBFieldInfo";
_fieldinfo = new b4a.example.dbutils._dbfieldinfo();
RDebugUtils.currentLine=9633798;
 //BA.debugLineNum = 9633798;BA.debugLine="FieldInfo.Initialize";
_fieldinfo.Initialize();
RDebugUtils.currentLine=9633799;
 //BA.debugLineNum = 9633799;BA.debugLine="FieldInfo.FieldName = values(1)";
_fieldinfo.FieldName /*String*/  = _values[(int) (1)];
RDebugUtils.currentLine=9633800;
 //BA.debugLineNum = 9633800;BA.debugLine="FieldInfo.DataType = values(2)";
_fieldinfo.DataType /*String*/  = _values[(int) (2)];
RDebugUtils.currentLine=9633801;
 //BA.debugLineNum = 9633801;BA.debugLine="FieldInfo.CanBeNull = (values(3) = 1)";
_fieldinfo.CanBeNull /*boolean*/  = ((_values[(int) (3)]).equals(BA.NumberToString(1)));
RDebugUtils.currentLine=9633802;
 //BA.debugLineNum = 9633802;BA.debugLine="FieldInfo.DefValue = values(4)";
_fieldinfo.DefValue /*Object*/  = (Object)(_values[(int) (4)]);
RDebugUtils.currentLine=9633803;
 //BA.debugLineNum = 9633803;BA.debugLine="lstFieldsInfo.Add(FieldInfo)";
_lstfieldsinfo.Add((Object)(_fieldinfo));
 }
};
RDebugUtils.currentLine=9633806;
 //BA.debugLineNum = 9633806;BA.debugLine="Return lstFieldsInfo";
if (true) return _lstfieldsinfo;
RDebugUtils.currentLine=9633807;
 //BA.debugLineNum = 9633807;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _gettables(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _db) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "gettables", true))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(null, "gettables", new Object[] {_ba,_db}));}
RDebugUtils.currentLine=9568256;
 //BA.debugLineNum = 9568256;BA.debugLine="Public Sub GetTables(DB As SQL) As List";
RDebugUtils.currentLine=9568257;
 //BA.debugLineNum = 9568257;BA.debugLine="Return ExecuteList(DB, \"SELECT name FROM sqlite_m";
if (true) return _executelist(_ba,_db,"SELECT name FROM sqlite_master WHERE type = 'table'",(String[])(anywheresoftware.b4a.keywords.Common.Null),(int) (0));
RDebugUtils.currentLine=9568258;
 //BA.debugLineNum = 9568258;BA.debugLine="End Sub";
return null;
}
public static boolean  _insertmaps(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.List _listofmaps) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "insertmaps", true))
	 {return ((Boolean) Debug.delegate(null, "insertmaps", new Object[] {_ba,_sql,_tablename,_listofmaps}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _columns = null;
anywheresoftware.b4a.keywords.StringBuilderWrapper _values = null;
boolean _res = false;
int _i1 = 0;
anywheresoftware.b4a.objects.collections.List _listofvalues = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
String _col = "";
Object _value = null;
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Public Sub InsertMaps(SQL As SQL, TableName As Str";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="Dim sb, columns, values As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_columns = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
_values = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="Dim res As Boolean = False";
_res = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=8585220;
 //BA.debugLineNum = 8585220;BA.debugLine="If ListOfMaps.Size > 1 And ListOfMaps.Get(0) = Li";
if (_listofmaps.getSize()>1 && (_listofmaps.Get((int) (0))).equals(_listofmaps.Get((int) (1)))) { 
RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="Log(\"Same Map found twice in list. Each item in";
anywheresoftware.b4a.keywords.Common.LogImpl("98585221","Same Map found twice in list. Each item in the list should include a different map object.",0);
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="Return res";
if (true) return _res;
 };
RDebugUtils.currentLine=8585224;
 //BA.debugLineNum = 8585224;BA.debugLine="SQL.BeginTransaction";
_sql.BeginTransaction();
RDebugUtils.currentLine=8585225;
 //BA.debugLineNum = 8585225;BA.debugLine="Try";
try {RDebugUtils.currentLine=8585226;
 //BA.debugLineNum = 8585226;BA.debugLine="For i1 = 0 To ListOfMaps.Size - 1";
{
final int step9 = 1;
final int limit9 = (int) (_listofmaps.getSize()-1);
_i1 = (int) (0) ;
for (;_i1 <= limit9 ;_i1 = _i1 + step9 ) {
RDebugUtils.currentLine=8585227;
 //BA.debugLineNum = 8585227;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=8585228;
 //BA.debugLineNum = 8585228;BA.debugLine="columns.Initialize";
_columns.Initialize();
RDebugUtils.currentLine=8585229;
 //BA.debugLineNum = 8585229;BA.debugLine="values.Initialize";
_values.Initialize();
RDebugUtils.currentLine=8585230;
 //BA.debugLineNum = 8585230;BA.debugLine="Dim listOfValues As List";
_listofvalues = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8585231;
 //BA.debugLineNum = 8585231;BA.debugLine="listOfValues.Initialize";
_listofvalues.Initialize();
RDebugUtils.currentLine=8585232;
 //BA.debugLineNum = 8585232;BA.debugLine="sb.Append(\"INSERT INTO [\" & TableName & \"] (\")";
_sb.Append("INSERT INTO ["+_tablename+"] (");
RDebugUtils.currentLine=8585233;
 //BA.debugLineNum = 8585233;BA.debugLine="Dim m As Map = ListOfMaps.Get(i1)";
_m = new anywheresoftware.b4a.objects.collections.Map();
_m = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_listofmaps.Get(_i1)));
RDebugUtils.currentLine=8585234;
 //BA.debugLineNum = 8585234;BA.debugLine="For Each col As String In m.Keys";
{
final anywheresoftware.b4a.BA.IterableList group17 = _m.Keys();
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_col = BA.ObjectToString(group17.Get(index17));
RDebugUtils.currentLine=8585235;
 //BA.debugLineNum = 8585235;BA.debugLine="Dim value As Object = m.Get(col)";
_value = _m.Get((Object)(_col));
RDebugUtils.currentLine=8585236;
 //BA.debugLineNum = 8585236;BA.debugLine="If listOfValues.Size > 0 Then";
if (_listofvalues.getSize()>0) { 
RDebugUtils.currentLine=8585237;
 //BA.debugLineNum = 8585237;BA.debugLine="columns.Append(\", \")";
_columns.Append(", ");
RDebugUtils.currentLine=8585238;
 //BA.debugLineNum = 8585238;BA.debugLine="values.Append(\", \")";
_values.Append(", ");
 };
RDebugUtils.currentLine=8585240;
 //BA.debugLineNum = 8585240;BA.debugLine="columns.Append(EscapeField(col))";
_columns.Append(_escapefield(_ba,_col));
RDebugUtils.currentLine=8585241;
 //BA.debugLineNum = 8585241;BA.debugLine="values.Append(\"?\")";
_values.Append("?");
RDebugUtils.currentLine=8585242;
 //BA.debugLineNum = 8585242;BA.debugLine="listOfValues.Add(value)";
_listofvalues.Add(_value);
 }
};
RDebugUtils.currentLine=8585244;
 //BA.debugLineNum = 8585244;BA.debugLine="sb.Append(columns.ToString).Append(\") VALUES (\"";
_sb.Append(_columns.ToString()).Append(") VALUES (").Append(_values.ToString()).Append(")");
RDebugUtils.currentLine=8585246;
 //BA.debugLineNum = 8585246;BA.debugLine="If i1 = 0 Then Log(\"InsertMaps (first query out";
if (_i1==0) { 
anywheresoftware.b4a.keywords.Common.LogImpl("98585246","InsertMaps (first query out of "+BA.NumberToString(_listofmaps.getSize())+"): "+_sb.ToString(),0);};
RDebugUtils.currentLine=8585248;
 //BA.debugLineNum = 8585248;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, listOfValues)";
_sql.ExecNonQuery2(_sb.ToString(),_listofvalues);
 }
};
RDebugUtils.currentLine=8585250;
 //BA.debugLineNum = 8585250;BA.debugLine="SQL.TransactionSuccessful";
_sql.TransactionSuccessful();
RDebugUtils.currentLine=8585251;
 //BA.debugLineNum = 8585251;BA.debugLine="res = True";
_res = anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e34) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e34);RDebugUtils.currentLine=8585253;
 //BA.debugLineNum = 8585253;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("98585253",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(_ba)),0);
 };
RDebugUtils.currentLine=8585259;
 //BA.debugLineNum = 8585259;BA.debugLine="SQL.EndTransaction";
_sql.EndTransaction();
RDebugUtils.currentLine=8585261;
 //BA.debugLineNum = 8585261;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8585262;
 //BA.debugLineNum = 8585262;BA.debugLine="End Sub";
return false;
}
public static String  _setdbversion(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,int _version) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "setdbversion", true))
	 {return ((String) Debug.delegate(null, "setdbversion", new Object[] {_ba,_sql,_version}));}
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Public Sub SetDBVersion (SQL As SQL, Version As In";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="SQL.ExecNonQuery2(\"UPDATE DBVersion set version =";
_sql.ExecNonQuery2("UPDATE DBVersion set version = ?",anywheresoftware.b4a.keywords.Common.ArrayToList(new Object[]{(Object)(_version)}));
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="End Sub";
return "";
}
public static String  _updaterecord(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,String _field,Object _newvalue,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "updaterecord", true))
	 {return ((String) Debug.delegate(null, "updaterecord", new Object[] {_ba,_sql,_tablename,_field,_newvalue,_wherefieldequals}));}
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Public Sub UpdateRecord(SQL As SQL, TableName As S";
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="UpdateRecord2(SQL, TableName, CreateMap(Field: Ne";
_updaterecord2(_ba,_sql,_tablename,anywheresoftware.b4a.keywords.Common.createMap(new Object[] {(Object)(_field),_newvalue}),_wherefieldequals);
RDebugUtils.currentLine=9306115;
 //BA.debugLineNum = 9306115;BA.debugLine="End Sub";
return "";
}
public static String  _updaterecord2(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.sql.SQL _sql,String _tablename,anywheresoftware.b4a.objects.collections.Map _fields,anywheresoftware.b4a.objects.collections.Map _wherefieldequals) throws Exception{
RDebugUtils.currentModule="dbutils";
if (Debug.shouldDelegate(null, "updaterecord2", true))
	 {return ((String) Debug.delegate(null, "updaterecord2", new Object[] {_ba,_sql,_tablename,_fields,_wherefieldequals}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.collections.List _args = null;
String _col = "";
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Public Sub UpdateRecord2(SQL As SQL, TableName As";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
if (_wherefieldequals.getSize()==0) { 
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("99371650","WhereFieldEquals map empty!",0);
RDebugUtils.currentLine=9371651;
 //BA.debugLineNum = 9371651;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=9371653;
 //BA.debugLineNum = 9371653;BA.debugLine="If Fields.Size = 0 Then";
if (_fields.getSize()==0) { 
RDebugUtils.currentLine=9371654;
 //BA.debugLineNum = 9371654;BA.debugLine="Log(\"Fields empty\")";
anywheresoftware.b4a.keywords.Common.LogImpl("99371654","Fields empty",0);
RDebugUtils.currentLine=9371655;
 //BA.debugLineNum = 9371655;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=9371657;
 //BA.debugLineNum = 9371657;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=9371658;
 //BA.debugLineNum = 9371658;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=9371659;
 //BA.debugLineNum = 9371659;BA.debugLine="sb.Append(\"UPDATE \").Append(EscapeField(TableName";
_sb.Append("UPDATE ").Append(_escapefield(_ba,_tablename)).Append(" SET ");
RDebugUtils.currentLine=9371660;
 //BA.debugLineNum = 9371660;BA.debugLine="Dim args As List";
_args = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9371661;
 //BA.debugLineNum = 9371661;BA.debugLine="args.Initialize";
_args.Initialize();
RDebugUtils.currentLine=9371662;
 //BA.debugLineNum = 9371662;BA.debugLine="For Each col As String In Fields.Keys";
{
final anywheresoftware.b4a.BA.IterableList group14 = _fields.Keys();
final int groupLen14 = group14.getSize()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_col = BA.ObjectToString(group14.Get(index14));
RDebugUtils.currentLine=9371663;
 //BA.debugLineNum = 9371663;BA.debugLine="sb.Append(EscapeField(col)).Append(\"=?\")";
_sb.Append(_escapefield(_ba,_col)).Append("=?");
RDebugUtils.currentLine=9371664;
 //BA.debugLineNum = 9371664;BA.debugLine="sb.Append(\",\")";
_sb.Append(",");
RDebugUtils.currentLine=9371665;
 //BA.debugLineNum = 9371665;BA.debugLine="args.Add(Fields.Get(col))";
_args.Add(_fields.Get((Object)(_col)));
 }
};
RDebugUtils.currentLine=9371667;
 //BA.debugLineNum = 9371667;BA.debugLine="sb.Remove(sb.Length - 1, sb.Length)";
_sb.Remove((int) (_sb.getLength()-1),_sb.getLength());
RDebugUtils.currentLine=9371668;
 //BA.debugLineNum = 9371668;BA.debugLine="sb.Append(\" WHERE \")";
_sb.Append(" WHERE ");
RDebugUtils.currentLine=9371669;
 //BA.debugLineNum = 9371669;BA.debugLine="For Each col As String In WhereFieldEquals.Keys";
{
final anywheresoftware.b4a.BA.IterableList group21 = _wherefieldequals.Keys();
final int groupLen21 = group21.getSize()
;int index21 = 0;
;
for (; index21 < groupLen21;index21++){
_col = BA.ObjectToString(group21.Get(index21));
RDebugUtils.currentLine=9371670;
 //BA.debugLineNum = 9371670;BA.debugLine="sb.Append(EscapeField(col)).Append(\" = ?\")";
_sb.Append(_escapefield(_ba,_col)).Append(" = ?");
RDebugUtils.currentLine=9371671;
 //BA.debugLineNum = 9371671;BA.debugLine="sb.Append(\" AND \")";
_sb.Append(" AND ");
RDebugUtils.currentLine=9371672;
 //BA.debugLineNum = 9371672;BA.debugLine="args.Add(WhereFieldEquals.Get(col))";
_args.Add(_wherefieldequals.Get((Object)(_col)));
 }
};
RDebugUtils.currentLine=9371674;
 //BA.debugLineNum = 9371674;BA.debugLine="sb.Remove(sb.Length - \" AND \".Length, sb.Length)";
_sb.Remove((int) (_sb.getLength()-" AND ".length()),_sb.getLength());
RDebugUtils.currentLine=9371675;
 //BA.debugLineNum = 9371675;BA.debugLine="Log(\"UpdateRecord: \" & sb.ToString)";
anywheresoftware.b4a.keywords.Common.LogImpl("99371675","UpdateRecord: "+_sb.ToString(),0);
RDebugUtils.currentLine=9371676;
 //BA.debugLineNum = 9371676;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
_sql.ExecNonQuery2(_sb.ToString(),_args);
RDebugUtils.currentLine=9371677;
 //BA.debugLineNum = 9371677;BA.debugLine="End Sub";
return "";
}
}