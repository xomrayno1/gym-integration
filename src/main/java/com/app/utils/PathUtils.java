package com.app.utils;

public class PathUtils {

	private PathUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static final String VERSION_V1 = "v1";

	public static final String API = "api";

	public static final String SLASH = "/";

	public static final String HEALTH_CHECK_API = "/healthCheck";

	public static final String USER_SERVICE = "user-service";
	
	public static final String API_V1_PREFIX = SLASH + API + SLASH + VERSION_V1;

	// user api
	public static final String USER_API = "users";

	public static final String USER_API_V1 = API_V1_PREFIX + SLASH + USER_API;

	// category api
	public static final String CATEGORY_API = "category";

	public static final String CATEGORY_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + CATEGORY_API;

	public static final String CATEGORY_PAGING_SEARCH_SORT_FILTER = SLASH + "category_paging_search_sort_filter";

	public static final String CATEGORY_GET_BY_ID = SLASH + "category_by_id/{id}";

	public static final String CATEGORY_CREATE = SLASH + "category_create";

	public static final String CATEGORY_UPDATE = SLASH + "category_update";

	public static final String CATEGORY_DELETES = SLASH + "category_deletes";

	public static final String CATEGORY_GET_ALL = SLASH + "category_get_all";

	// product api
	public static final String PRODUCT_API = "product";

	public static final String PRODUCT_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + PRODUCT_API;

	public static final String PRODUCT_PAGING_SEARCH_SORT_FILTER = SLASH + "product_paging_search_sort_filter";

	public static final String PRODUCT_GET_BY_ID = SLASH + "product_by_id/{id}";

	public static final String PRODUCT_CREATE = SLASH + "product_create";

	public static final String PRODUCT_UPDATE = SLASH + "product_update";

	public static final String PRODUCT_DELETES = SLASH + "product_deletes";

	public static final String PRODUCT_GET_ALL = SLASH + "product_get_all";

	// training schedule api
	public static final String TRAINING_SCHEDULE_API = "training_schedule";

	public static final String TRAINING_SCHEDULE_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH
			+ TRAINING_SCHEDULE_API;

	public static final String TRAINING_SCHEDULE_PAGING_SEARCH_SORT_FILTER = SLASH
			+ "training_schedule_paging_search_sort_filter";

	public static final String TRAINING_SCHEDULE_GET_BY_ID = SLASH + "training_schedule_by_id/{id}";

	public static final String TRAINING_SCHEDULE_CREATE = SLASH + "training_schedule_create";

	public static final String TRAINING_SCHEDULE_UPDATE = SLASH + "training_schedule_update";

	public static final String TRAINING_SCHEDULE_DELETES = SLASH + "training_schedule_deletes";

	public static final String TRAINING_SCHEDULE_GET_ALL = SLASH + "training_schedule_get_all";
	
	public static final String TRAINING_SCHEDULE_DETAIL_EXPORT_PDF = SLASH + "training_schedule_detail/pdf/{id}";

	// common api

	public static final String COMMON_API = "common";

	public static final String COMMON_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + COMMON_API;

	public static final String CYCLE_WEEK_API = "cycle_week";

	public static final String COMMON_CYCLE_WEEK_API_V1 = COMMON_API_V1 + SLASH + CYCLE_WEEK_API;

	public static final String COMMON_CYCLE_WEEK_GET_UPCOMING_WEEKS = SLASH + "get_upcoming_weeks";

	public static final String COMMON_CYCLE_WEEK_GET_BY_ID = SLASH + "get_by_id/{id}";
	
	
	//Metabolic Rate api
	
	public static final String METABOLIC_RATE_API = "metabolic_rate";
	
	public static final String METABOLIC_RATE_CALCULATION = SLASH + "metabolic_rate_calculation";
	
	//auth api
	public static final String AUTH_API =  "/api/authenticate";
	public static final String AUTH_LOGIN_API = AUTH_API + SLASH +"login";
	public static final String AUTH_FACEBOOK_LOGIN_API =  AUTH_API + "/facebook/login";
	public static final String LOGOUT_API =  AUTH_API + "/logout";
	public static final String REGISTER_API = SLASH +"register";
	
	//swagger api
	public static final String SWAGGER_END_POINT =  "/swagger-ui/**";
	
	public static final String SWAGGER_OPEN_API_END_POINT =  "/v3/api-docs/**";
}
