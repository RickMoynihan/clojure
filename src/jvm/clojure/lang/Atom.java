/**
 *   Copyright (c) Rich Hickey. All rights reserved.
 *   The use and distribution terms for this software are covered by the
 *   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
 *   which can be found in the file epl-v10.html at the root of this distribution.
 *   By using this software in any fashion, you are agreeing to be bound by
 * 	 the terms of this license.
 *   You must not remove this notice, or any other, from this software.
 **/

/* rich Jan 1, 2009 */

package clojure.lang;

import java.util.concurrent.atomic.AtomicReference;

public class Atom extends ARef{
    final AtomicReference state;

    public Atom(Object state) {
        this.state = new AtomicReference(state);
    }

    public Atom(Object state, IPersistentMap meta) {
        super(meta);
        this.state = new AtomicReference(state);
    }

    public Object get() {
        return state.get();
    }

    public Object swap(IFn f, ISeq args) throws Exception {
        for(;;)
            {
            Object v = get();
            Object newv = f.applyTo(new Cons(v, args));
            validate(newv);
            if(state.compareAndSet(v,newv))
                {
                if(v != newv)
                    notifyWatches();
                return newv;
                }
            }
    }

    public boolean compareAndSet(Object oldv, Object newv){
        validate(newv);
        boolean ret = state.compareAndSet(oldv, newv);
        if (ret && oldv != newv)
            notifyWatches();
        return ret;
    }

    public Object reset(Object newval){
        validate(newval);
        state.set(newval);
        notifyWatches();
        return newval;
    }
}
