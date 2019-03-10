package de.bmuskalla.callhierarchy.toggletestfilter;

import org.eclipse.core.commands.State;
import org.eclipse.jdt.internal.corext.callhierarchy.CallHierarchy;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jface.util.IPropertyChangeListener;

public class ToggleTestFilterState extends State {

	private final IPropertyChangeListener changeListener = event -> {
		if (event.getProperty().equals("PREF_FILTER_TESTCODE")) {
			setValue((Boolean)event.getNewValue());
		}
	};
	
	public ToggleTestFilterState() {
		JavaPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(changeListener);
	}
	
	@Override
	public void dispose() {
		JavaPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(changeListener);
	}

	@Override
	public Object getValue() {
		return CallHierarchy.getDefault().isFilterTestCode();
	}

	@Override
	public void setValue(Object value) {
		CallHierarchy.getDefault().setFilterTestCode((boolean) value);
		super.setValue(value);
	}

}
