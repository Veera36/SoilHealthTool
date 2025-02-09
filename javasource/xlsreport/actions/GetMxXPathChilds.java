// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package xlsreport.actions;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.thirdparty.org.json.JSONArray;
import com.mendix.thirdparty.org.json.JSONObject;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class GetMxXPathChilds extends CustomJavaAction<java.lang.String>
{
	/** @deprecated use Parameter.getMendixObject() instead. */
	@java.lang.Deprecated(forRemoval = true)
	private final IMendixObject __Parameter;
	private final xlsreport.proxies.MxXPath Parameter;

	public GetMxXPathChilds(
		IContext context,
		IMendixObject _parameter
	)
	{
		super(context);
		this.__Parameter = _parameter;
		this.Parameter = _parameter == null ? null : xlsreport.proxies.MxXPath.initialize(getContext(), _parameter);
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		if(Parameter == null)
			return null;
		findChilds(Parameter);
		return jsonarry.toString();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetMxXPathChilds";
	}

	// BEGIN EXTRA CODE
	JSONArray jsonarry = new JSONArray();
	void findChilds(xlsreport.proxies.MxXPath parent) throws CoreException
	{
		var child = parent.getMxXPath_ParentMxXPath();
		if(child != null)
		{
			var json = new JSONObject();
			json.put("rType", child.getRetrieveType());
			json.put("subV", child.getSubVisible());
			var objMem = child.getMxXPath_MxObjectMember();
			if(objMem != null)
			{
				json.put("objMem_CN", objMem.getCompleteName());
			}
			var objRef = child.getMxXPath_MxObjectReference();
			if(objRef != null)
			{
				json.put("objRef_CN", objRef.getCompleteName());
			}
			var objType = child.getMxXPath_MxObjectType();
			if(objType != null)
			{
				json.put("objType_CN", objType.getCompleteName());
			}
			jsonarry.put(json);
			findChilds(child);
		}
	}
	// END EXTRA CODE
}
