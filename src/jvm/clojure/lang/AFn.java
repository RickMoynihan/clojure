/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* rich Mar 25, 2006 4:05:37 PM */

package clojure.lang;

import java.util.Comparator;
import java.io.Serializable;

public abstract class AFn extends Obj implements IFn, Comparator, Serializable{

public AFn(IPersistentMap meta){
	super(meta);
}

public AFn(){
}

public Obj withMeta(IPersistentMap meta){
	throw new UnsupportedOperationException();
}

public Object call() throws Exception{
	return invoke();
}

public void run(){
	try
		{
		invoke();
		}
	catch(Exception e)
		{
		throw new RuntimeException(e);
		}
}

public int compare(Object o1, Object o2){
	try
		{
		Object o = invoke(o1, o2);

		if(o instanceof Boolean)
			{
			if(RT.booleanCast(o))
				return -1;
			return RT.booleanCast(invoke(o2,o1))? 1 : 0;
			}
		
		Number n = (Number) o;
		return n.intValue();
		}
	catch(Exception e)
		{
		throw new RuntimeException(e);
		}
}

public Object invoke() throws Exception{
	return throwArity();
}

public Object invoke(Object arg1) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7)
		throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13)
		throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14)
		throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18, Object arg19) throws Exception{
	return throwArity();
}

public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20)
		throws Exception{
	return throwArity();
}


public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                     Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                     Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20,
                     Object... args)
		throws Exception{
	return throwArity();
}

public Object applyTo(ISeq arglist) throws Exception{
	return applyToHelper(this, arglist);
}

static public Object applyToHelper(IFn ifn, ISeq arglist) throws Exception{
	switch(RT.boundedLength(arglist, 20))
		{
		case 0:
			return ifn.invoke();
		case 1:
			return ifn.invoke(arglist.first());
		case 2:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
			);
		case 3:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 4:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 5:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 6:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 7:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 8:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 9:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 10:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 11:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 12:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 13:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 14:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 15:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 16:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 17:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 18:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 19:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		case 20:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
			);
		default:
			return ifn.invoke(arglist.first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, (arglist = arglist.rest()).first()
					, RT.seqToArray(arglist.rest()));
		}
}

public Object throwArity(){
	String name = getClass().getSimpleName();
	int suffix = name.lastIndexOf("__");
	throw new IllegalArgumentException("Wrong number of args passed to: "
	                                   + (suffix == -1 ? name : name.substring(0, suffix)).replace('_', '-'));
}
}
