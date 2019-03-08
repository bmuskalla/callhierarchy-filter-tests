package de.bmuskalla.callhierarchy.toggletestfilter;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.State;
import org.eclipse.jdt.internal.ui.callhierarchy.CallHierarchyViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.handlers.RegistryToggleState;

public class ToggleTestFilterHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		toggleState(event);
		getCallHierarchyView().refresh();
		return null;
	}

	private void toggleState(ExecutionEvent event) throws ExecutionException {
		Command command = event.getCommand();
		HandlerUtil.toggleCommandState(command);
	}

	private boolean getToggleState(Command command) {
		State state = command.getState(RegistryToggleState.STATE_ID);
		return (Boolean) state.getValue();
	}

	private CallHierarchyViewPart getCallHierarchyView() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		return (CallHierarchyViewPart) window.getActivePage()
				.findView("org.eclipse.jdt.callhierarchy.view");
	}

}
