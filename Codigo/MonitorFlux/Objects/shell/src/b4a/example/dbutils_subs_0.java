package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class dbutils_subs_0 {


public static RemoteObject  _copydbfromassets(RemoteObject _ba,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("CopyDBFromAssets (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,52);
if (RapidSub.canDelegate("copydbfromassets")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","copydbfromassets", _ba, _filename);}
RemoteObject _targetdir = RemoteObject.createImmutable("");
;
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 52;BA.debugLine="Public Sub CopyDBFromAssets (FileName As String) A";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 53;BA.debugLine="Dim TargetDir As String = GetDBFolder";
Debug.JustUpdateDeviceLine();
_targetdir = _getdbfolder(_ba);Debug.locals.put("TargetDir", _targetdir);Debug.locals.put("TargetDir", _targetdir);
 BA.debugLineNum = 54;BA.debugLine="If File.Exists(TargetDir, FileName) = False Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(_targetdir),(Object)(_filename)),dbutils.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 55;BA.debugLine="File.Copy(File.DirAssets, FileName, TargetDir, F";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(_filename),(Object)(_targetdir),(Object)(_filename));
 };
 BA.debugLineNum = 57;BA.debugLine="Return TargetDir";
Debug.JustUpdateDeviceLine();
if (true) return _targetdir;
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createtable(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _fieldsandtypes,RemoteObject _primarykey) throws Exception{
try {
		Debug.PushSubsStack("CreateTable (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,96);
if (RapidSub.canDelegate("createtable")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","createtable", _ba, _sql, _tablename, _fieldsandtypes, _primarykey);}
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _field = RemoteObject.createImmutable("");
RemoteObject _ftype = RemoteObject.createImmutable("");
RemoteObject _query = RemoteObject.createImmutable("");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("FieldsAndTypes", _fieldsandtypes);
Debug.locals.put("PrimaryKey", _primarykey);
 BA.debugLineNum = 96;BA.debugLine="Public Sub CreateTable(SQL As SQL, TableName As St";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 97;BA.debugLine="Dim sb As StringBuilder";
Debug.JustUpdateDeviceLine();
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 98;BA.debugLine="sb.Initialize";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 99;BA.debugLine="sb.Append(\"(\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("(")));
 BA.debugLineNum = 100;BA.debugLine="For i = 0 To FieldsAndTypes.Size - 1";
Debug.JustUpdateDeviceLine();
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_fieldsandtypes.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 101;BA.debugLine="Dim field, ftype As String";
Debug.JustUpdateDeviceLine();
_field = RemoteObject.createImmutable("");Debug.locals.put("field", _field);
_ftype = RemoteObject.createImmutable("");Debug.locals.put("ftype", _ftype);
 BA.debugLineNum = 102;BA.debugLine="field = FieldsAndTypes.GetKeyAt(i)";
Debug.JustUpdateDeviceLine();
_field = BA.ObjectToString(_fieldsandtypes.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("field", _field);
 BA.debugLineNum = 103;BA.debugLine="ftype = FieldsAndTypes.GetValueAt(i)";
Debug.JustUpdateDeviceLine();
_ftype = BA.ObjectToString(_fieldsandtypes.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("ftype", _ftype);
 BA.debugLineNum = 104;BA.debugLine="If i > 0 Then sb.Append(\", \")";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean(">",RemoteObject.createImmutable(_i),BA.numberCast(double.class, 0))) { 
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));};
 BA.debugLineNum = 105;BA.debugLine="sb.Append(EscapeField(field)).Append(\" \").Append";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(_escapefield(_ba,_field))).runMethod(false,"Append",(Object)(RemoteObject.createImmutable(" "))).runVoidMethod ("Append",(Object)(_ftype));
 BA.debugLineNum = 106;BA.debugLine="If field = PrimaryKey Then sb.Append(\" PRIMARY K";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_field,_primarykey)) { 
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" PRIMARY KEY")));};
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 108;BA.debugLine="sb.Append(\")\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(")")));
 BA.debugLineNum = 109;BA.debugLine="Dim query As String = \"CREATE TABLE IF NOT EXISTS";
Debug.JustUpdateDeviceLine();
_query = RemoteObject.concat(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS "),_escapefield(_ba,_tablename),RemoteObject.createImmutable(" "),_sb.runMethod(true,"ToString"));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 111;BA.debugLine="Log(\"CreateTable: \" & query)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98454159",RemoteObject.concat(RemoteObject.createImmutable("CreateTable: "),_query),0);
 BA.debugLineNum = 113;BA.debugLine="SQL.ExecNonQuery(query)";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deleterecord(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _wherefieldequals) throws Exception{
try {
		Debug.PushSubsStack("DeleteRecord (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,490);
if (RapidSub.canDelegate("deleterecord")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","deleterecord", _ba, _sql, _tablename, _wherefieldequals);}
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _args = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _col = RemoteObject.createImmutable("");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("WhereFieldEquals", _wherefieldequals);
 BA.debugLineNum = 490;BA.debugLine="Public Sub DeleteRecord(SQL As SQL, TableName As S";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 491;BA.debugLine="Dim sb As StringBuilder";
Debug.JustUpdateDeviceLine();
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 492;BA.debugLine="sb.Initialize";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 493;BA.debugLine="sb.Append(\"DELETE FROM \" & EscapeField(TableName)";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("DELETE FROM "),_escapefield(_ba,_tablename),RemoteObject.createImmutable(" WHERE "))));
 BA.debugLineNum = 494;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_wherefieldequals.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 495;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99437189",RemoteObject.createImmutable("WhereFieldEquals map empty!"),0);
 BA.debugLineNum = 496;BA.debugLine="Return";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 498;BA.debugLine="Dim args As List";
Debug.JustUpdateDeviceLine();
_args = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("args", _args);
 BA.debugLineNum = 499;BA.debugLine="args.Initialize";
Debug.JustUpdateDeviceLine();
_args.runVoidMethod ("Initialize");
 BA.debugLineNum = 500;BA.debugLine="For Each col As String In WhereFieldEquals.Keys";
Debug.JustUpdateDeviceLine();
{
final RemoteObject group10 = _wherefieldequals.runMethod(false,"Keys");
final int groupLen10 = group10.runMethod(true,"getSize").<Integer>get()
;int index10 = 0;
;
for (; index10 < groupLen10;index10++){
_col = BA.ObjectToString(group10.runMethod(false,"Get",index10));Debug.locals.put("col", _col);
Debug.locals.put("col", _col);
 BA.debugLineNum = 501;BA.debugLine="If args.Size > 0 Then sb.Append(\" AND \")";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean(">",_args.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));};
 BA.debugLineNum = 502;BA.debugLine="sb.Append(EscapeField(col)).Append(\" = ?\")";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(_escapefield(_ba,_col))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" = ?")));
 BA.debugLineNum = 503;BA.debugLine="args.Add(WhereFieldEquals.Get(col))";
Debug.JustUpdateDeviceLine();
_args.runVoidMethod ("Add",(Object)(_wherefieldequals.runMethod(false,"Get",(Object)((_col)))));
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 506;BA.debugLine="Log(\"DeleteRecord: \" & sb.ToString)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99437200",RemoteObject.concat(RemoteObject.createImmutable("DeleteRecord: "),_sb.runMethod(true,"ToString")),0);
 BA.debugLineNum = 508;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("ExecNonQuery2",(Object)(_sb.runMethod(true,"ToString")),(Object)(_args));
 BA.debugLineNum = 509;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _droptable(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename) throws Exception{
try {
		Debug.PushSubsStack("DropTable (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,118);
if (RapidSub.canDelegate("droptable")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","droptable", _ba, _sql, _tablename);}
RemoteObject _query = RemoteObject.createImmutable("");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
 BA.debugLineNum = 118;BA.debugLine="Public Sub DropTable(SQL As SQL, TableName As Stri";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 119;BA.debugLine="Dim query As String = \"DROP TABLE IF EXISTS\" & Es";
Debug.JustUpdateDeviceLine();
_query = RemoteObject.concat(RemoteObject.createImmutable("DROP TABLE IF EXISTS"),_escapefield(_ba,_tablename));Debug.locals.put("query", _query);Debug.locals.put("query", _query);
 BA.debugLineNum = 121;BA.debugLine="Log(\"DropTable: \" & query)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98519683",RemoteObject.concat(RemoteObject.createImmutable("DropTable: "),_query),0);
 BA.debugLineNum = 123;BA.debugLine="SQL.ExecNonQuery(query)";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("ExecNonQuery",(Object)(_query));
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _escapefield(RemoteObject _ba,RemoteObject _f) throws Exception{
try {
		Debug.PushSubsStack("EscapeField (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,65);
if (RapidSub.canDelegate("escapefield")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","escapefield", _ba, _f);}
;
Debug.locals.put("f", _f);
 BA.debugLineNum = 65;BA.debugLine="Private Sub EscapeField(f As String) As String";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 66;BA.debugLine="Return \"[\" & f & \"]\"";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.concat(RemoteObject.createImmutable("["),_f,RemoteObject.createImmutable("]"));
 BA.debugLineNum = 67;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executehtml(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _clickable) throws Exception{
try {
		Debug.PushSubsStack("ExecuteHtml (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,365);
if (RapidSub.canDelegate("executehtml")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executehtml", _ba, _sql, _query, _stringargs, _limit, _clickable);}
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
int _i = 0;
RemoteObject _row = RemoteObject.createImmutable(0);
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("Clickable", _clickable);
 BA.debugLineNum = 365;BA.debugLine="Public Sub ExecuteHtml(SQL As SQL, Query As String";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 366;BA.debugLine="Dim cur As ResultSet";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 367;BA.debugLine="If StringArgs <> Null Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 368;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 370;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 373;BA.debugLine="Log(\"ExecuteHtml: \" & Query)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99109512",RemoteObject.concat(RemoteObject.createImmutable("ExecuteHtml: "),_query),0);
 BA.debugLineNum = 376;BA.debugLine="Dim sb As StringBuilder";
Debug.JustUpdateDeviceLine();
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 377;BA.debugLine="sb.Initialize";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 378;BA.debugLine="sb.Append(\"<html><body>\").Append(CRLF)";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<html><body>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 379;BA.debugLine="sb.Append(\"<style type='text/css'>\").Append(HtmlC";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<style type='text/css'>"))).runMethod(false,"Append",(Object)(dbutils._htmlcss)).runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</style>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 380;BA.debugLine="sb.Append(\"<table><thead><tr>\").Append(CRLF)";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<table><thead><tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 381;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.JustUpdateDeviceLine();
{
final int step13 = 1;
final int limit13 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step13 > 0 && _i <= limit13) || (step13 < 0 && _i >= limit13) ;_i = ((int)(0 + _i + step13))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 382;BA.debugLine="sb.Append(\"<th>\").Append(cur.GetColumnName(i)).A";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<th>"))).runMethod(false,"Append",(Object)(_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</th>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 384;BA.debugLine="sb.Append(\"</thead>\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</thead>")));
 BA.debugLineNum = 394;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 395;BA.debugLine="Dim row As Int";
Debug.JustUpdateDeviceLine();
_row = RemoteObject.createImmutable(0);Debug.locals.put("row", _row);
 BA.debugLineNum = 396;BA.debugLine="Do While cur.NextRow";
Debug.JustUpdateDeviceLine();
while (_cur.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 397;BA.debugLine="If row Mod 2 = 0 Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",RemoteObject.solve(new RemoteObject[] {_row,RemoteObject.createImmutable(2)}, "%",0, 1),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 398;BA.debugLine="sb.Append(\"<tr>\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr>")));
 }else {
 BA.debugLineNum = 400;BA.debugLine="sb.Append(\"<tr class='odd'>\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<tr class='odd'>")));
 };
 BA.debugLineNum = 402;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.JustUpdateDeviceLine();
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25) ;_i = ((int)(0 + _i + step25))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 403;BA.debugLine="sb.Append(\"<td>\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("<td>")));
 BA.debugLineNum = 404;BA.debugLine="If Clickable Then";
Debug.JustUpdateDeviceLine();
if (_clickable.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 405;BA.debugLine="sb.Append(\"<a href='http://\").Append(i).Append";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("<a href='http://"))).runMethod(false,"Append",(Object)(BA.NumberToString(_i))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(".")));
 BA.debugLineNum = 406;BA.debugLine="sb.Append(row)";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(BA.NumberToString(_row)));
 BA.debugLineNum = 407;BA.debugLine="sb.Append(\".stub'>\").Append(cur.GetString2(i))";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable(".stub'>"))).runMethod(false,"Append",(Object)(_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</a>")));
 }else {
 BA.debugLineNum = 409;BA.debugLine="sb.Append(cur.GetString2(i))";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i)))));
 };
 BA.debugLineNum = 411;BA.debugLine="sb.Append(\"</td>\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</td>")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 413;BA.debugLine="sb.Append(\"</tr>\").Append(CRLF)";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("</tr>"))).runVoidMethod ("Append",(Object)(dbutils.mostCurrent.__c.getField(true,"CRLF")));
 BA.debugLineNum = 414;BA.debugLine="row = row + 1";
Debug.JustUpdateDeviceLine();
_row = RemoteObject.solve(new RemoteObject[] {_row,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("row", _row);
 }
;
 BA.debugLineNum = 416;BA.debugLine="cur.Close";
Debug.JustUpdateDeviceLine();
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 417;BA.debugLine="sb.Append(\"</table></body></html>\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("</table></body></html>")));
 BA.debugLineNum = 418;BA.debugLine="Return sb.ToString";
Debug.JustUpdateDeviceLine();
if (true) return _sb.runMethod(true,"ToString");
 BA.debugLineNum = 419;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executejson(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _dbtypes) throws Exception{
try {
		Debug.PushSubsStack("ExecuteJSON (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,325);
if (RapidSub.canDelegate("executejson")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executejson", _ba, _sql, _query, _stringargs, _limit, _dbtypes);}
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("DBTypes", _dbtypes);
 BA.debugLineNum = 325;BA.debugLine="Public Sub ExecuteJSON (SQL As SQL, Query As Strin";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 326;BA.debugLine="Dim table As List";
Debug.JustUpdateDeviceLine();
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("table", _table);
 BA.debugLineNum = 327;BA.debugLine="Dim cur As ResultSet";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 328;BA.debugLine="If StringArgs <> Null Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 329;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 331;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 334;BA.debugLine="Log(\"ExecuteJSON: \" & Query)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99043977",RemoteObject.concat(RemoteObject.createImmutable("ExecuteJSON: "),_query),0);
 BA.debugLineNum = 336;BA.debugLine="Dim table As List";
Debug.JustUpdateDeviceLine();
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("table", _table);
 BA.debugLineNum = 337;BA.debugLine="table.Initialize";
Debug.JustUpdateDeviceLine();
_table.runVoidMethod ("Initialize");
 BA.debugLineNum = 338;BA.debugLine="Do While cur.NextRow";
Debug.JustUpdateDeviceLine();
while (_cur.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 339;BA.debugLine="Dim m As Map";
Debug.JustUpdateDeviceLine();
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 340;BA.debugLine="m.Initialize";
Debug.JustUpdateDeviceLine();
_m.runVoidMethod ("Initialize");
 BA.debugLineNum = 341;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.JustUpdateDeviceLine();
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14) ;_i = ((int)(0 + _i + step14))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 342;BA.debugLine="Select DBTypes.Get(i)";
Debug.JustUpdateDeviceLine();
switch (BA.switchObjectToInt(_dbtypes.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))),(dbutils._db_text),(dbutils._db_integer),(dbutils._db_real))) {
case 0: {
 BA.debugLineNum = 344;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetString2(i)";
Debug.JustUpdateDeviceLine();
_m.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))),(Object)((_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))));
 break; }
case 1: {
 BA.debugLineNum = 346;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetLong2(i))";
Debug.JustUpdateDeviceLine();
_m.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))),(Object)((_cur.runMethod(true,"GetLong2",(Object)(BA.numberCast(int.class, _i))))));
 break; }
case 2: {
 BA.debugLineNum = 348;BA.debugLine="m.Put(cur.GetColumnName(i), cur.GetDouble2(i)";
Debug.JustUpdateDeviceLine();
_m.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))))),(Object)((_cur.runMethod(true,"GetDouble2",(Object)(BA.numberCast(int.class, _i))))));
 break; }
default: {
 BA.debugLineNum = 350;BA.debugLine="Log(\"Invalid type: \" & DBTypes.Get(i))";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99043993",RemoteObject.concat(RemoteObject.createImmutable("Invalid type: "),_dbtypes.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),0);
 break; }
}
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 353;BA.debugLine="table.Add(m)";
Debug.JustUpdateDeviceLine();
_table.runVoidMethod ("Add",(Object)((_m.getObject())));
 BA.debugLineNum = 354;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean(">",_limit,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("g",_table.runMethod(true,"getSize"),BA.numberCast(double.class, _limit))) { 
if (true) break;};
 }
;
 BA.debugLineNum = 356;BA.debugLine="cur.Close";
Debug.JustUpdateDeviceLine();
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 357;BA.debugLine="Dim root As Map";
Debug.JustUpdateDeviceLine();
_root = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("root", _root);
 BA.debugLineNum = 358;BA.debugLine="root.Initialize";
Debug.JustUpdateDeviceLine();
_root.runVoidMethod ("Initialize");
 BA.debugLineNum = 359;BA.debugLine="root.Put(\"root\", table)";
Debug.JustUpdateDeviceLine();
_root.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("root"))),(Object)((_table.getObject())));
 BA.debugLineNum = 360;BA.debugLine="Return root";
Debug.JustUpdateDeviceLine();
if (true) return _root;
 BA.debugLineNum = 361;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executelist(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit) throws Exception{
try {
		Debug.PushSubsStack("ExecuteList (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,305);
if (RapidSub.canDelegate("executelist")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executelist", _ba, _sql, _query, _stringargs, _limit);}
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cols = null;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
 BA.debugLineNum = 305;BA.debugLine="Public Sub ExecuteList(SQL As SQL, Query As String";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 306;BA.debugLine="Dim Table As List = ExecuteMemoryTable(SQL, Query";
Debug.JustUpdateDeviceLine();
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);Debug.locals.put("Table", _table);Debug.locals.put("Table", _table);
 BA.debugLineNum = 307;BA.debugLine="Dim res As List";
Debug.JustUpdateDeviceLine();
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 308;BA.debugLine="res.Initialize";
Debug.JustUpdateDeviceLine();
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 309;BA.debugLine="For Each Cols() As String In Table";
Debug.JustUpdateDeviceLine();
{
final RemoteObject group4 = _table;
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_cols = (group4.runMethod(false,"Get",index4));Debug.locals.put("Cols", _cols);
Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 310;BA.debugLine="res.Add(Cols(0))";
Debug.JustUpdateDeviceLine();
_res.runVoidMethod ("Add",(Object)((_cols.getArrayElement(true,BA.numberCast(int.class, 0)))));
 }
}Debug.locals.put("Cols", _cols);
;
 BA.debugLineNum = 312;BA.debugLine="Return res";
Debug.JustUpdateDeviceLine();
if (true) return _res;
 BA.debugLineNum = 313;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executelist2(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _list) throws Exception{
try {
		Debug.PushSubsStack("ExecuteList2 (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,300);
if (RapidSub.canDelegate("executelist2")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executelist2", _ba, _sql, _query, _stringargs, _limit, _list);}
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("List", _list);
 BA.debugLineNum = 300;BA.debugLine="Public Sub ExecuteList2(SQL As SQL, Query As Strin";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 301;BA.debugLine="List.Clear";
Debug.JustUpdateDeviceLine();
_list.runVoidMethod ("Clear");
 BA.debugLineNum = 302;BA.debugLine="List.AddAll(ExecuteList(SQL, Query, StringArgs, L";
Debug.JustUpdateDeviceLine();
_list.runVoidMethod ("AddAll",(Object)(_executelist(_ba,_sql,_query,_stringargs,_limit)));
 BA.debugLineNum = 303;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executelistview(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _listview1,RemoteObject _twolines) throws Exception{
try {
		Debug.PushSubsStack("ExecuteListView (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,256);
if (RapidSub.canDelegate("executelistview")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executelistview", _ba, _sql, _query, _stringargs, _limit, _listview1, _twolines);}
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cols = null;
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("ListView1", _listview1);
Debug.locals.put("TwoLines", _twolines);
 BA.debugLineNum = 256;BA.debugLine="Public Sub ExecuteListView(SQL As SQL, Query As St";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 258;BA.debugLine="ListView1.Clear";
Debug.JustUpdateDeviceLine();
_listview1.runVoidMethod ("Clear");
 BA.debugLineNum = 259;BA.debugLine="Dim Table As List";
Debug.JustUpdateDeviceLine();
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Table", _table);
 BA.debugLineNum = 260;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
Debug.JustUpdateDeviceLine();
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);Debug.locals.put("Table", _table);
 BA.debugLineNum = 261;BA.debugLine="Dim Cols() As String";
Debug.JustUpdateDeviceLine();
_cols = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 262;BA.debugLine="For i = 0 To Table.Size - 1";
Debug.JustUpdateDeviceLine();
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_table.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 263;BA.debugLine="Cols = Table.Get(i)";
Debug.JustUpdateDeviceLine();
_cols = (_table.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 264;BA.debugLine="If TwoLines Then";
Debug.JustUpdateDeviceLine();
if (_twolines.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 265;BA.debugLine="ListView1.AddTwoLines2(Cols(0), Cols(1), Cols)";
Debug.JustUpdateDeviceLine();
_listview1.runVoidMethod ("AddTwoLines2",(Object)(BA.ObjectToCharSequence(_cols.getArrayElement(true,BA.numberCast(int.class, 0)))),(Object)(BA.ObjectToCharSequence(_cols.getArrayElement(true,BA.numberCast(int.class, 1)))),(Object)((_cols)));
 }else {
 BA.debugLineNum = 267;BA.debugLine="ListView1.AddSingleLine2(Cols(0), Cols)";
Debug.JustUpdateDeviceLine();
_listview1.runVoidMethod ("AddSingleLine2",(Object)(BA.ObjectToCharSequence(_cols.getArrayElement(true,BA.numberCast(int.class, 0)))),(Object)((_cols)));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 270;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executemap(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs) throws Exception{
try {
		Debug.PushSubsStack("ExecuteMap (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,213);
if (RapidSub.canDelegate("executemap")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executemap", _ba, _sql, _query, _stringargs);}
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
 BA.debugLineNum = 213;BA.debugLine="Public Sub ExecuteMap(SQL As SQL, Query As String,";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 214;BA.debugLine="Dim res As Map";
Debug.JustUpdateDeviceLine();
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("res", _res);
 BA.debugLineNum = 215;BA.debugLine="Dim cur As ResultSet";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 216;BA.debugLine="If StringArgs <> Null Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("N",_stringargs)) { 
 BA.debugLineNum = 217;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 }else {
 BA.debugLineNum = 219;BA.debugLine="cur = SQL.ExecQuery(Query)";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _sql.runMethod(false,"ExecQuery",(Object)(_query)));
 };
 BA.debugLineNum = 222;BA.debugLine="Log(\"ExecuteMap: \" & Query)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98716297",RemoteObject.concat(RemoteObject.createImmutable("ExecuteMap: "),_query),0);
 BA.debugLineNum = 224;BA.debugLine="If cur.NextRow = False Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_cur.runMethod(true,"NextRow"),dbutils.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 226;BA.debugLine="Log(\"No records found.\")";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98716301",RemoteObject.createImmutable("No records found."),0);
 BA.debugLineNum = 228;BA.debugLine="Return res";
Debug.JustUpdateDeviceLine();
if (true) return _res;
 };
 BA.debugLineNum = 230;BA.debugLine="res.Initialize";
Debug.JustUpdateDeviceLine();
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 231;BA.debugLine="For i = 0 To cur.ColumnCount - 1";
Debug.JustUpdateDeviceLine();
{
final int step14 = 1;
final int limit14 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14) ;_i = ((int)(0 + _i + step14))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 232;BA.debugLine="res.Put(cur.GetColumnName(i).ToLowerCase, cur.Ge";
Debug.JustUpdateDeviceLine();
_res.runVoidMethod ("Put",(Object)((_cur.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _i))).runMethod(true,"toLowerCase"))),(Object)((_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _i))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 234;BA.debugLine="cur.Close";
Debug.JustUpdateDeviceLine();
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 235;BA.debugLine="Return res";
Debug.JustUpdateDeviceLine();
if (true) return _res;
 BA.debugLineNum = 236;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executememorytable(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit) throws Exception{
try {
		Debug.PushSubsStack("ExecuteMemoryTable (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,186);
if (RapidSub.canDelegate("executememorytable")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executememorytable", _ba, _sql, _query, _stringargs, _limit);}
RemoteObject _cur = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _values = null;
int _col = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("Limit", _limit);
 BA.debugLineNum = 186;BA.debugLine="Public Sub ExecuteMemoryTable(SQL As SQL, Query As";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 187;BA.debugLine="Dim cur As ResultSet";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");Debug.locals.put("cur", _cur);
 BA.debugLineNum = 188;BA.debugLine="If StringArgs = Null Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("n",_stringargs)) { 
 BA.debugLineNum = 189;BA.debugLine="Dim StringArgs(0) As String";
Debug.JustUpdateDeviceLine();
_stringargs = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("StringArgs", _stringargs);
 };
 BA.debugLineNum = 191;BA.debugLine="cur = SQL.ExecQuery2(Query, StringArgs)";
Debug.JustUpdateDeviceLine();
_cur = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.ResultSetWrapper"), _sql.runMethod(false,"ExecQuery2",(Object)(_query),(Object)(_stringargs)));
 BA.debugLineNum = 193;BA.debugLine="Log(\"ExecuteMemoryTable: \" & Query)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98650759",RemoteObject.concat(RemoteObject.createImmutable("ExecuteMemoryTable: "),_query),0);
 BA.debugLineNum = 195;BA.debugLine="Dim table As List";
Debug.JustUpdateDeviceLine();
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("table", _table);
 BA.debugLineNum = 196;BA.debugLine="table.Initialize";
Debug.JustUpdateDeviceLine();
_table.runVoidMethod ("Initialize");
 BA.debugLineNum = 197;BA.debugLine="Do While cur.NextRow";
Debug.JustUpdateDeviceLine();
while (_cur.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 198;BA.debugLine="Dim values(cur.ColumnCount) As String";
Debug.JustUpdateDeviceLine();
_values = RemoteObject.createNewArray ("String", new int[] {_cur.runMethod(true,"getColumnCount").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("values", _values);
 BA.debugLineNum = 199;BA.debugLine="For col = 0 To cur.ColumnCount - 1";
Debug.JustUpdateDeviceLine();
{
final int step11 = 1;
final int limit11 = RemoteObject.solve(new RemoteObject[] {_cur.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step11 > 0 && _col <= limit11) || (step11 < 0 && _col >= limit11) ;_col = ((int)(0 + _col + step11))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 200;BA.debugLine="values(col) = cur.GetString2(col)";
Debug.JustUpdateDeviceLine();
_values.setArrayElement (_cur.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _col))),BA.numberCast(int.class, _col));
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 202;BA.debugLine="table.Add(values)";
Debug.JustUpdateDeviceLine();
_table.runVoidMethod ("Add",(Object)((_values)));
 BA.debugLineNum = 203;BA.debugLine="If Limit > 0 And table.Size >= Limit Then Exit";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean(">",_limit,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("g",_table.runMethod(true,"getSize"),BA.numberCast(double.class, _limit))) { 
if (true) break;};
 }
;
 BA.debugLineNum = 205;BA.debugLine="cur.Close";
Debug.JustUpdateDeviceLine();
_cur.runVoidMethod ("Close");
 BA.debugLineNum = 206;BA.debugLine="Return table";
Debug.JustUpdateDeviceLine();
if (true) return _table;
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _executespinner(RemoteObject _ba,RemoteObject _sql,RemoteObject _query,RemoteObject _stringargs,RemoteObject _limit,RemoteObject _spinner1) throws Exception{
try {
		Debug.PushSubsStack("ExecuteSpinner (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,240);
if (RapidSub.canDelegate("executespinner")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","executespinner", _ba, _sql, _query, _stringargs, _limit, _spinner1);}
RemoteObject _table = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cols = null;
int _i = 0;
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Query", _query);
Debug.locals.put("StringArgs", _stringargs);
Debug.locals.put("Limit", _limit);
Debug.locals.put("Spinner1", _spinner1);
 BA.debugLineNum = 240;BA.debugLine="Sub ExecuteSpinner(SQL As SQL, Query As String, St";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 241;BA.debugLine="Spinner1.Clear";
Debug.JustUpdateDeviceLine();
_spinner1.runVoidMethod ("Clear");
 BA.debugLineNum = 242;BA.debugLine="Dim Table As List";
Debug.JustUpdateDeviceLine();
_table = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("Table", _table);
 BA.debugLineNum = 243;BA.debugLine="Table = ExecuteMemoryTable(SQL, Query, StringArgs";
Debug.JustUpdateDeviceLine();
_table = _executememorytable(_ba,_sql,_query,_stringargs,_limit);Debug.locals.put("Table", _table);
 BA.debugLineNum = 245;BA.debugLine="Dim Cols() As String";
Debug.JustUpdateDeviceLine();
_cols = RemoteObject.createNewArray ("String", new int[] {0}, new Object[]{});Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 246;BA.debugLine="For i = 0 To Table.Size - 1";
Debug.JustUpdateDeviceLine();
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_table.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 247;BA.debugLine="Cols = Table.Get(i)";
Debug.JustUpdateDeviceLine();
_cols = (_table.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("Cols", _cols);
 BA.debugLineNum = 248;BA.debugLine="Spinner1.Add(Cols(0))";
Debug.JustUpdateDeviceLine();
_spinner1.runVoidMethod ("Add",(Object)(_cols.getArrayElement(true,BA.numberCast(int.class, 0))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 250;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdbfolder(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetDBFolder (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,39);
if (RapidSub.canDelegate("getdbfolder")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","getdbfolder", _ba);}
RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
;
 BA.debugLineNum = 39;BA.debugLine="Public Sub GetDBFolder As String";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 41;BA.debugLine="Dim rp As RuntimePermissions";
Debug.JustUpdateDeviceLine();
_rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");Debug.locals.put("rp", _rp);
 BA.debugLineNum = 42;BA.debugLine="If File.ExternalWritable Then Return rp.GetSafeDi";
Debug.JustUpdateDeviceLine();
if (dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"getExternalWritable").<Boolean>get().booleanValue()) { 
if (true) return _rp.runMethod(true,"GetSafeDirDefaultExternal",(Object)(RemoteObject.createImmutable("")));}
else {
if (true) return dbutils.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");};
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdbversion(RemoteObject _ba,RemoteObject _sql) throws Exception{
try {
		Debug.PushSubsStack("GetDBVersion (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,423);
if (RapidSub.canDelegate("getdbversion")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","getdbversion", _ba, _sql);}
RemoteObject _version = RemoteObject.createImmutable(0);
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
;
Debug.locals.put("SQL", _sql);
 BA.debugLineNum = 423;BA.debugLine="Public Sub GetDBVersion (SQL As SQL) As Int";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 424;BA.debugLine="Dim version As Int";
Debug.JustUpdateDeviceLine();
_version = RemoteObject.createImmutable(0);Debug.locals.put("version", _version);
 BA.debugLineNum = 425;BA.debugLine="If TableExists(SQL, \"DBVersion\") Then";
Debug.JustUpdateDeviceLine();
if (_tableexists(_ba,_sql,RemoteObject.createImmutable("DBVersion")).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 426;BA.debugLine="version = SQL.ExecQuerySingleResult(\"SELECT vers";
Debug.JustUpdateDeviceLine();
_version = BA.numberCast(int.class, _sql.runMethod(true,"ExecQuerySingleResult",(Object)(RemoteObject.createImmutable("SELECT version FROM DBVersion"))));Debug.locals.put("version", _version);
 }else {
 BA.debugLineNum = 432;BA.debugLine="Dim m As Map = CreateMap(\"version\": DB_INTEGER)";
Debug.JustUpdateDeviceLine();
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m = dbutils.mostCurrent.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {RemoteObject.createImmutable(("version")),(dbutils._db_integer)}));Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 433;BA.debugLine="CreateTable(SQL, \"DBVersion\", m, \"version\")";
Debug.JustUpdateDeviceLine();
_createtable(_ba,_sql,BA.ObjectToString("DBVersion"),_m,RemoteObject.createImmutable("version"));
 BA.debugLineNum = 435;BA.debugLine="SQL.ExecNonQuery(\"INSERT INTO DBVersion VALUES (";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("INSERT INTO DBVersion VALUES (1)")));
 BA.debugLineNum = 436;BA.debugLine="version = 1";
Debug.JustUpdateDeviceLine();
_version = BA.numberCast(int.class, 1);Debug.locals.put("version", _version);
 };
 BA.debugLineNum = 438;BA.debugLine="Return version";
Debug.JustUpdateDeviceLine();
if (true) return _version;
 BA.debugLineNum = 439;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getfieldsinfo(RemoteObject _ba,RemoteObject _db,RemoteObject _tablename) throws Exception{
try {
		Debug.PushSubsStack("GetFieldsInfo (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,524);
if (RapidSub.canDelegate("getfieldsinfo")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","getfieldsinfo", _ba, _db, _tablename);}
RemoteObject _lstfieldsinfo = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _fieldslist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _values = null;
RemoteObject _fieldinfo = RemoteObject.declareNull("b4a.example.dbutils._dbfieldinfo");
;
Debug.locals.put("DB", _db);
Debug.locals.put("TableName", _tablename);
 BA.debugLineNum = 524;BA.debugLine="Public Sub GetFieldsInfo(DB As SQL, TableName As S";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 525;BA.debugLine="Dim lstFieldsInfo As List";
Debug.JustUpdateDeviceLine();
_lstfieldsinfo = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lstFieldsInfo", _lstfieldsinfo);
 BA.debugLineNum = 526;BA.debugLine="lstFieldsInfo.Initialize";
Debug.JustUpdateDeviceLine();
_lstfieldsinfo.runVoidMethod ("Initialize");
 BA.debugLineNum = 527;BA.debugLine="Dim FieldsList As List = ExecuteMemoryTable(DB, \"";
Debug.JustUpdateDeviceLine();
_fieldslist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_fieldslist = _executememorytable(_ba,_db,RemoteObject.concat(RemoteObject.createImmutable("PRAGMA table_info ('"),_tablename,RemoteObject.createImmutable("')")),(dbutils.mostCurrent.__c.getField(false,"Null")),BA.numberCast(int.class, 0));Debug.locals.put("FieldsList", _fieldslist);Debug.locals.put("FieldsList", _fieldslist);
 BA.debugLineNum = 528;BA.debugLine="For Each values() As String In FieldsList";
Debug.JustUpdateDeviceLine();
{
final RemoteObject group4 = _fieldslist;
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_values = (group4.runMethod(false,"Get",index4));Debug.locals.put("values", _values);
Debug.locals.put("values", _values);
 BA.debugLineNum = 529;BA.debugLine="Dim FieldInfo As DBFieldInfo";
Debug.JustUpdateDeviceLine();
_fieldinfo = RemoteObject.createNew ("b4a.example.dbutils._dbfieldinfo");Debug.locals.put("FieldInfo", _fieldinfo);
 BA.debugLineNum = 530;BA.debugLine="FieldInfo.Initialize";
Debug.JustUpdateDeviceLine();
_fieldinfo.runVoidMethod ("Initialize");
 BA.debugLineNum = 531;BA.debugLine="FieldInfo.FieldName = values(1)";
Debug.JustUpdateDeviceLine();
_fieldinfo.setField ("FieldName" /*RemoteObject*/ ,_values.getArrayElement(true,BA.numberCast(int.class, 1)));
 BA.debugLineNum = 532;BA.debugLine="FieldInfo.DataType = values(2)";
Debug.JustUpdateDeviceLine();
_fieldinfo.setField ("DataType" /*RemoteObject*/ ,_values.getArrayElement(true,BA.numberCast(int.class, 2)));
 BA.debugLineNum = 533;BA.debugLine="FieldInfo.CanBeNull = (values(3) = 1)";
Debug.JustUpdateDeviceLine();
_fieldinfo.setField ("CanBeNull" /*RemoteObject*/ ,BA.ObjectToBoolean((RemoteObject.solveBoolean("=",_values.getArrayElement(true,BA.numberCast(int.class, 3)),BA.NumberToString(1)))));
 BA.debugLineNum = 534;BA.debugLine="FieldInfo.DefValue = values(4)";
Debug.JustUpdateDeviceLine();
_fieldinfo.setField ("DefValue" /*RemoteObject*/ ,(_values.getArrayElement(true,BA.numberCast(int.class, 4))));
 BA.debugLineNum = 535;BA.debugLine="lstFieldsInfo.Add(FieldInfo)";
Debug.JustUpdateDeviceLine();
_lstfieldsinfo.runVoidMethod ("Add",(Object)((_fieldinfo)));
 }
}Debug.locals.put("values", _values);
;
 BA.debugLineNum = 538;BA.debugLine="Return lstFieldsInfo";
Debug.JustUpdateDeviceLine();
if (true) return _lstfieldsinfo;
 BA.debugLineNum = 539;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _gettables(RemoteObject _ba,RemoteObject _db) throws Exception{
try {
		Debug.PushSubsStack("GetTables (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,518);
if (RapidSub.canDelegate("gettables")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","gettables", _ba, _db);}
;
Debug.locals.put("DB", _db);
 BA.debugLineNum = 518;BA.debugLine="Public Sub GetTables(DB As SQL) As List";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 519;BA.debugLine="Return ExecuteList(DB, \"SELECT name FROM sqlite_m";
Debug.JustUpdateDeviceLine();
if (true) return _executelist(_ba,_db,BA.ObjectToString("SELECT name FROM sqlite_master WHERE type = 'table'"),(dbutils.mostCurrent.__c.getField(false,"Null")),BA.numberCast(int.class, 0));
 BA.debugLineNum = 520;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertmaps(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _listofmaps) throws Exception{
try {
		Debug.PushSubsStack("InsertMaps (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,131);
if (RapidSub.canDelegate("insertmaps")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","insertmaps", _ba, _sql, _tablename, _listofmaps);}
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _columns = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _values = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _res = RemoteObject.createImmutable(false);
int _i1 = 0;
RemoteObject _listofvalues = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _col = RemoteObject.createImmutable("");
RemoteObject _value = RemoteObject.declareNull("Object");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("ListOfMaps", _listofmaps);
 BA.debugLineNum = 131;BA.debugLine="Public Sub InsertMaps(SQL As SQL, TableName As Str";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 132;BA.debugLine="Dim sb, columns, values As StringBuilder";
Debug.JustUpdateDeviceLine();
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
_columns = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("columns", _columns);
_values = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("values", _values);
 BA.debugLineNum = 133;BA.debugLine="Dim res As Boolean = False";
Debug.JustUpdateDeviceLine();
_res = dbutils.mostCurrent.__c.getField(true,"False");Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 135;BA.debugLine="If ListOfMaps.Size > 1 And ListOfMaps.Get(0) = Li";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean(">",_listofmaps.runMethod(true,"getSize"),BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",_listofmaps.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))),_listofmaps.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 1))))) { 
 BA.debugLineNum = 136;BA.debugLine="Log(\"Same Map found twice in list. Each item in";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98585221",RemoteObject.createImmutable("Same Map found twice in list. Each item in the list should include a different map object."),0);
 BA.debugLineNum = 137;BA.debugLine="Return res";
Debug.JustUpdateDeviceLine();
if (true) return _res;
 };
 BA.debugLineNum = 139;BA.debugLine="SQL.BeginTransaction";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("BeginTransaction");
 BA.debugLineNum = 140;BA.debugLine="Try";
Debug.JustUpdateDeviceLine();
try { BA.debugLineNum = 141;BA.debugLine="For i1 = 0 To ListOfMaps.Size - 1";
Debug.JustUpdateDeviceLine();
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_listofmaps.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i1 = 0 ;
for (;(step9 > 0 && _i1 <= limit9) || (step9 < 0 && _i1 >= limit9) ;_i1 = ((int)(0 + _i1 + step9))  ) {
Debug.locals.put("i1", _i1);
 BA.debugLineNum = 142;BA.debugLine="sb.Initialize";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 143;BA.debugLine="columns.Initialize";
Debug.JustUpdateDeviceLine();
_columns.runVoidMethod ("Initialize");
 BA.debugLineNum = 144;BA.debugLine="values.Initialize";
Debug.JustUpdateDeviceLine();
_values.runVoidMethod ("Initialize");
 BA.debugLineNum = 145;BA.debugLine="Dim listOfValues As List";
Debug.JustUpdateDeviceLine();
_listofvalues = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("listOfValues", _listofvalues);
 BA.debugLineNum = 146;BA.debugLine="listOfValues.Initialize";
Debug.JustUpdateDeviceLine();
_listofvalues.runVoidMethod ("Initialize");
 BA.debugLineNum = 147;BA.debugLine="sb.Append(\"INSERT INTO [\" & TableName & \"] (\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO ["),_tablename,RemoteObject.createImmutable("] ("))));
 BA.debugLineNum = 148;BA.debugLine="Dim m As Map = ListOfMaps.Get(i1)";
Debug.JustUpdateDeviceLine();
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
_m = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _listofmaps.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i1))));Debug.locals.put("m", _m);
 BA.debugLineNum = 149;BA.debugLine="For Each col As String In m.Keys";
Debug.JustUpdateDeviceLine();
{
final RemoteObject group17 = _m.runMethod(false,"Keys");
final int groupLen17 = group17.runMethod(true,"getSize").<Integer>get()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_col = BA.ObjectToString(group17.runMethod(false,"Get",index17));Debug.locals.put("col", _col);
Debug.locals.put("col", _col);
 BA.debugLineNum = 150;BA.debugLine="Dim value As Object = m.Get(col)";
Debug.JustUpdateDeviceLine();
_value = _m.runMethod(false,"Get",(Object)((_col)));Debug.locals.put("value", _value);Debug.locals.put("value", _value);
 BA.debugLineNum = 151;BA.debugLine="If listOfValues.Size > 0 Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean(">",_listofvalues.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 152;BA.debugLine="columns.Append(\", \")";
Debug.JustUpdateDeviceLine();
_columns.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 BA.debugLineNum = 153;BA.debugLine="values.Append(\", \")";
Debug.JustUpdateDeviceLine();
_values.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(", ")));
 };
 BA.debugLineNum = 155;BA.debugLine="columns.Append(EscapeField(col))";
Debug.JustUpdateDeviceLine();
_columns.runVoidMethod ("Append",(Object)(_escapefield(_ba,_col)));
 BA.debugLineNum = 156;BA.debugLine="values.Append(\"?\")";
Debug.JustUpdateDeviceLine();
_values.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("?")));
 BA.debugLineNum = 157;BA.debugLine="listOfValues.Add(value)";
Debug.JustUpdateDeviceLine();
_listofvalues.runVoidMethod ("Add",(Object)(_value));
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 159;BA.debugLine="sb.Append(columns.ToString).Append(\") VALUES (\"";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(_columns.runMethod(true,"ToString"))).runMethod(false,"Append",(Object)(RemoteObject.createImmutable(") VALUES ("))).runMethod(false,"Append",(Object)(_values.runMethod(true,"ToString"))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(")")));
 BA.debugLineNum = 161;BA.debugLine="If i1 = 0 Then Log(\"InsertMaps (first query out";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(_i1),BA.numberCast(double.class, 0))) { 
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98585246",RemoteObject.concat(RemoteObject.createImmutable("InsertMaps (first query out of "),_listofmaps.runMethod(true,"getSize"),RemoteObject.createImmutable("): "),_sb.runMethod(true,"ToString")),0);};
 BA.debugLineNum = 163;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, listOfValues)";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("ExecNonQuery2",(Object)(_sb.runMethod(true,"ToString")),(Object)(_listofvalues));
 }
}Debug.locals.put("i1", _i1);
;
 BA.debugLineNum = 165;BA.debugLine="SQL.TransactionSuccessful";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("TransactionSuccessful");
 BA.debugLineNum = 166;BA.debugLine="res = True";
Debug.JustUpdateDeviceLine();
_res = dbutils.mostCurrent.__c.getField(true,"True");Debug.locals.put("res", _res);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e34) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e34.toString()); BA.debugLineNum = 168;BA.debugLine="Log(LastException)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","98585253",BA.ObjectToString(dbutils.mostCurrent.__c.runMethod(false,"LastException",_ba)),0);
 };
 BA.debugLineNum = 174;BA.debugLine="SQL.EndTransaction";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("EndTransaction");
 BA.debugLineNum = 176;BA.debugLine="Return res";
Debug.JustUpdateDeviceLine();
if (true) return _res;
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Type DBFieldInfo(FieldName As String, DataType As";
;
 //BA.debugLineNum = 5;BA.debugLine="Public DB_REAL, DB_INTEGER, DB_BLOB, DB_TEXT As S";
dbutils._db_real = RemoteObject.createImmutable("");
dbutils._db_integer = RemoteObject.createImmutable("");
dbutils._db_blob = RemoteObject.createImmutable("");
dbutils._db_text = RemoteObject.createImmutable("");
 //BA.debugLineNum = 6;BA.debugLine="DB_REAL = \"REAL\"";
dbutils._db_real = BA.ObjectToString("REAL");
 //BA.debugLineNum = 7;BA.debugLine="DB_INTEGER = \"INTEGER\"";
dbutils._db_integer = BA.ObjectToString("INTEGER");
 //BA.debugLineNum = 8;BA.debugLine="DB_BLOB = \"BLOB\"";
dbutils._db_blob = BA.ObjectToString("BLOB");
 //BA.debugLineNum = 9;BA.debugLine="DB_TEXT = \"TEXT\"";
dbutils._db_text = BA.ObjectToString("TEXT");
 //BA.debugLineNum = 10;BA.debugLine="Public HtmlCSS As String = $\" 		table {width: 100";
dbutils._htmlcss = (RemoteObject.concat(RemoteObject.createImmutable("\n"),RemoteObject.createImmutable("		table {width: 100%;border: 1px solid #cef;text-align: left; }\n"),RemoteObject.createImmutable("		th { font-weight: bold;	background-color: #acf;	border-bottom: 1px solid #cef; }\n"),RemoteObject.createImmutable("		td,th {	padding: 4px 5px; }\n"),RemoteObject.createImmutable("		.odd {background-color: #def; } \n"),RemoteObject.createImmutable("		.odd td {border-bottom: 1px solid #cef; }\n"),RemoteObject.createImmutable("		a { text-decoration:none; color: #000;}")));
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _setdbversion(RemoteObject _ba,RemoteObject _sql,RemoteObject _version) throws Exception{
try {
		Debug.PushSubsStack("SetDBVersion (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,444);
if (RapidSub.canDelegate("setdbversion")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","setdbversion", _ba, _sql, _version);}
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("Version", _version);
 BA.debugLineNum = 444;BA.debugLine="Public Sub SetDBVersion (SQL As SQL, Version As In";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 445;BA.debugLine="SQL.ExecNonQuery2(\"UPDATE DBVersion set version =";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("UPDATE DBVersion set version = ?")),(Object)(dbutils.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_version)})))));
 BA.debugLineNum = 446;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tableexists(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename) throws Exception{
try {
		Debug.PushSubsStack("TableExists (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,512);
if (RapidSub.canDelegate("tableexists")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","tableexists", _ba, _sql, _tablename);}
RemoteObject _count = RemoteObject.createImmutable(0);
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
 BA.debugLineNum = 512;BA.debugLine="Public Sub TableExists(SQL As SQL, TableName As St";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 513;BA.debugLine="Dim count As Int = SQL.ExecQuerySingleResult2(\"SE";
Debug.JustUpdateDeviceLine();
_count = BA.numberCast(int.class, _sql.runMethod(true,"ExecQuerySingleResult2",(Object)(BA.ObjectToString("SELECT count(name) FROM sqlite_master WHERE type='table' AND name=? COLLATE NOCASE")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_tablename}))));Debug.locals.put("count", _count);Debug.locals.put("count", _count);
 BA.debugLineNum = 514;BA.debugLine="Return count > 0";
Debug.JustUpdateDeviceLine();
if (true) return BA.ObjectToBoolean(RemoteObject.solveBoolean(">",_count,BA.numberCast(double.class, 0)));
 BA.debugLineNum = 515;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updaterecord(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _field,RemoteObject _newvalue,RemoteObject _wherefieldequals) throws Exception{
try {
		Debug.PushSubsStack("UpdateRecord (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,450);
if (RapidSub.canDelegate("updaterecord")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","updaterecord", _ba, _sql, _tablename, _field, _newvalue, _wherefieldequals);}
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("Field", _field);
Debug.locals.put("NewValue", _newvalue);
Debug.locals.put("WhereFieldEquals", _wherefieldequals);
 BA.debugLineNum = 450;BA.debugLine="Public Sub UpdateRecord(SQL As SQL, TableName As S";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 452;BA.debugLine="UpdateRecord2(SQL, TableName, CreateMap(Field: Ne";
Debug.JustUpdateDeviceLine();
_updaterecord2(_ba,_sql,_tablename,dbutils.mostCurrent.__c.runMethod(false, "createMap", (Object)(new RemoteObject[] {(_field),_newvalue})),_wherefieldequals);
 BA.debugLineNum = 453;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updaterecord2(RemoteObject _ba,RemoteObject _sql,RemoteObject _tablename,RemoteObject _fields,RemoteObject _wherefieldequals) throws Exception{
try {
		Debug.PushSubsStack("UpdateRecord2 (dbutils) ","dbutils",10,_ba,dbutils.mostCurrent,457);
if (RapidSub.canDelegate("updaterecord2")) { return b4a.example.dbutils.remoteMe.runUserSub(false, "dbutils","updaterecord2", _ba, _sql, _tablename, _fields, _wherefieldequals);}
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _args = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _col = RemoteObject.createImmutable("");
;
Debug.locals.put("SQL", _sql);
Debug.locals.put("TableName", _tablename);
Debug.locals.put("Fields", _fields);
Debug.locals.put("WhereFieldEquals", _wherefieldequals);
 BA.debugLineNum = 457;BA.debugLine="Public Sub UpdateRecord2(SQL As SQL, TableName As";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 458;BA.debugLine="If WhereFieldEquals.Size = 0 Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_wherefieldequals.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 459;BA.debugLine="Log(\"WhereFieldEquals map empty!\")";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99371650",RemoteObject.createImmutable("WhereFieldEquals map empty!"),0);
 BA.debugLineNum = 460;BA.debugLine="Return";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 462;BA.debugLine="If Fields.Size = 0 Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_fields.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 463;BA.debugLine="Log(\"Fields empty\")";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99371654",RemoteObject.createImmutable("Fields empty"),0);
 BA.debugLineNum = 464;BA.debugLine="Return";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 466;BA.debugLine="Dim sb As StringBuilder";
Debug.JustUpdateDeviceLine();
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 467;BA.debugLine="sb.Initialize";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 468;BA.debugLine="sb.Append(\"UPDATE \").Append(EscapeField(TableName";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(RemoteObject.createImmutable("UPDATE "))).runMethod(false,"Append",(Object)(_escapefield(_ba,_tablename))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" SET ")));
 BA.debugLineNum = 469;BA.debugLine="Dim args As List";
Debug.JustUpdateDeviceLine();
_args = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("args", _args);
 BA.debugLineNum = 470;BA.debugLine="args.Initialize";
Debug.JustUpdateDeviceLine();
_args.runVoidMethod ("Initialize");
 BA.debugLineNum = 471;BA.debugLine="For Each col As String In Fields.Keys";
Debug.JustUpdateDeviceLine();
{
final RemoteObject group14 = _fields.runMethod(false,"Keys");
final int groupLen14 = group14.runMethod(true,"getSize").<Integer>get()
;int index14 = 0;
;
for (; index14 < groupLen14;index14++){
_col = BA.ObjectToString(group14.runMethod(false,"Get",index14));Debug.locals.put("col", _col);
Debug.locals.put("col", _col);
 BA.debugLineNum = 472;BA.debugLine="sb.Append(EscapeField(col)).Append(\"=?\")";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(_escapefield(_ba,_col))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable("=?")));
 BA.debugLineNum = 473;BA.debugLine="sb.Append(\",\")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(",")));
 BA.debugLineNum = 474;BA.debugLine="args.Add(Fields.Get(col))";
Debug.JustUpdateDeviceLine();
_args.runVoidMethod ("Add",(Object)(_fields.runMethod(false,"Get",(Object)((_col)))));
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 476;BA.debugLine="sb.Remove(sb.Length - 1, sb.Length)";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Remove",(Object)(RemoteObject.solve(new RemoteObject[] {_sb.runMethod(true,"getLength"),RemoteObject.createImmutable(1)}, "-",1, 1)),(Object)(_sb.runMethod(true,"getLength")));
 BA.debugLineNum = 477;BA.debugLine="sb.Append(\" WHERE \")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" WHERE ")));
 BA.debugLineNum = 478;BA.debugLine="For Each col As String In WhereFieldEquals.Keys";
Debug.JustUpdateDeviceLine();
{
final RemoteObject group21 = _wherefieldequals.runMethod(false,"Keys");
final int groupLen21 = group21.runMethod(true,"getSize").<Integer>get()
;int index21 = 0;
;
for (; index21 < groupLen21;index21++){
_col = BA.ObjectToString(group21.runMethod(false,"Get",index21));Debug.locals.put("col", _col);
Debug.locals.put("col", _col);
 BA.debugLineNum = 479;BA.debugLine="sb.Append(EscapeField(col)).Append(\" = ?\")";
Debug.JustUpdateDeviceLine();
_sb.runMethod(false,"Append",(Object)(_escapefield(_ba,_col))).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" = ?")));
 BA.debugLineNum = 480;BA.debugLine="sb.Append(\" AND \")";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" AND ")));
 BA.debugLineNum = 481;BA.debugLine="args.Add(WhereFieldEquals.Get(col))";
Debug.JustUpdateDeviceLine();
_args.runVoidMethod ("Add",(Object)(_wherefieldequals.runMethod(false,"Get",(Object)((_col)))));
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 483;BA.debugLine="sb.Remove(sb.Length - \" AND \".Length, sb.Length)";
Debug.JustUpdateDeviceLine();
_sb.runVoidMethod ("Remove",(Object)(RemoteObject.solve(new RemoteObject[] {_sb.runMethod(true,"getLength"),RemoteObject.createImmutable(" AND ").runMethod(true,"length")}, "-",1, 1)),(Object)(_sb.runMethod(true,"getLength")));
 BA.debugLineNum = 484;BA.debugLine="Log(\"UpdateRecord: \" & sb.ToString)";
Debug.JustUpdateDeviceLine();
dbutils.mostCurrent.__c.runVoidMethod ("LogImpl","99371675",RemoteObject.concat(RemoteObject.createImmutable("UpdateRecord: "),_sb.runMethod(true,"ToString")),0);
 BA.debugLineNum = 485;BA.debugLine="SQL.ExecNonQuery2(sb.ToString, args)";
Debug.JustUpdateDeviceLine();
_sql.runVoidMethod ("ExecNonQuery2",(Object)(_sb.runMethod(true,"ToString")),(Object)(_args));
 BA.debugLineNum = 486;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}