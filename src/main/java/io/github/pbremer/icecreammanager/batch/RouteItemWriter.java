/**
 * 
 */
package io.github.pbremer.icecreammanager.batch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.pbremer.icecreammanager.entity.Route;
import io.github.pbremer.icecreammanager.service.RouteService;

/**
 * @author Patrick Bremer
 */
public class RouteItemWriter implements ItemWriter<Route> {

    private static final Logger logger =
            LoggerFactory.getLogger(RouteItemWriter.class);

    @Autowired
    private RouteService routeService;

    /*
     * (non-Javadoc)
     * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
     */
    @Override
    public void write(List<? extends Route> items) throws Exception {
	List<Route> inactiveRoutes = new ArrayList<Route>();
	List<Route> activeRoutes = new ArrayList<Route>();
	for (Route route : items) {
	    if (route.getActive()) {
		activeRoutes.add(route);
	    } else {
		inactiveRoutes.add(route);
	    }
	}
	if (!activeRoutes.isEmpty()) {
	    logger.info("Adding {}", activeRoutes.size());
	    routeService.batchSave(activeRoutes);
	}
	if (!inactiveRoutes.isEmpty()) {
	    logger.info("Deactivating {}", inactiveRoutes.size());
	    routeService.inactivateRoutes(inactiveRoutes);
	}
    }

}
