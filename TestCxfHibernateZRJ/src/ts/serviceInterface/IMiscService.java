package ts.serviceInterface;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ts.model.CodeNamePair;
import ts.model.CustomerInfo;
import ts.model.PackageRoute;
import ts.model.Position;
import ts.model.Region;
import ts.model.TransHistory;
import ts.model.TransNode;
import ts.model.UserInfo;

@Path("/Misc")
public interface IMiscService {
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getNode/{ID}") 
	public Response getNode(@PathParam("ID")String ID);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getNodeByRegionCode/{RegionCode}") 
	public List<TransNode> getNodeByRegionCode(@PathParam("RegionCode")String RegionCode);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getNodeByTel/{TelCode}") 
	public TransNode getNodeByTel(@PathParam("TelCode")String telCode);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getNodesList/{RegionCode}/{Type}")
    //
	public List<TransNode> getNodesList(@PathParam("RegionCode")String regionCode, @PathParam("Type")int type);

    //===============================================================================================
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getCustomerListByName/{name}") 
	public List<CustomerInfo> getCustomerListByName(@PathParam("name")String name);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getCustomerListByTelCode/{TelCode}") 
	public List<CustomerInfo> getCustomerListByTelCode(@PathParam("TelCode")String TelCode);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getCustomerInfo/{id}") 
	public Response getCustomerInfo(@PathParam("id")String id);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/deleteCustomerInfo/{id}") 
	public Response deleteCustomerInfo(@PathParam("id")int id);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveCustomerInfo") 
	public Response saveCustomerInfo(CustomerInfo obj);
    
    //===============================================================================================
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getProvinceList") 
	public List<CodeNamePair> getProvinceList();
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getCityList/{prv}") 
	public List<CodeNamePair> getCityList(@PathParam("prv")String prv);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getTownList/{city}") 
	public List<CodeNamePair> getTownList(@PathParam("city")String city);
    
    @GET
    @Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
    @Path("/getRegionString/{id}") 
	public String getRegionString(@PathParam("id")String id);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getRegion/{id}") 
	public Region getRegion(@PathParam("id")String id);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLogin/{uid}/{pwd}")
    public Response doLogin(@PathParam("uid") int uid, @PathParam("pwd") String pwd);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/uploadRoute") 
	public Response savePackageRoute(PackageRoute obj);
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/getPackageRouteList/{expressSheetID}")
    public List<PackageRoute> getPackageRouteList(@PathParam("expressSheetID") String expressSheetID);
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/appointTransPorter/{packageID}/{nodeUID}/{userID}") 
    public String appointTransPorter(@PathParam("packageID")String packageID,@PathParam("nodeUID")int nodeUID,@PathParam("userID")int userID);
    
      
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/savePosition") 
	public Response savePosition(Position obj);
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveUserInfo") 
	public Response saveUserInfo(UserInfo obj);
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/changeUserInfo/{id}") 
	public Response changeUserInfo(@PathParam("id")int userUID,UserInfo obj);

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/getTransHistory/{expressSheetID}")
	public List<TransHistory> getTransHistory(@PathParam("expressSheetID") String expressSheetID);
	
	//===============================================================================================

    
    public void CreateWorkSession(int uid);

	public void RefreshSessionList();
	
}
