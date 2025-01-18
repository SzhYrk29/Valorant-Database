package com.project.mapper;

import com.project.dto.CalloutDTO;
import com.project.dto.MapDTO;
import com.project.model.Callout;
import com.project.model.Map;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapMapper {
    public Map mapMap(MapDTO mapDTO) {
        Map map = new Map();
        map.setUuid(mapDTO.uuid());
        map.setDisplayName(mapDTO.displayName());
        map.setTacticalDescription(mapDTO.tacticalDescription());
        map.setCoordinates(mapDTO.coordinates());
        map.setDisplayIcon(mapDTO.displayIcon());
        map.setSplash(mapDTO.splash());

        List<CalloutDTO> calloutDTOs = mapDTO.callouts() != null ? mapDTO.callouts() : List.of(); // Handle null
        List<Callout> callouts = new ArrayList<>();
        for (CalloutDTO calloutDTO : calloutDTOs) {
            callouts.add(mapCallout(calloutDTO, map));
        }
        map.setCallouts(callouts);

        return map;
    }


    public Callout mapCallout(CalloutDTO calloutDTO, Map map) {
        Callout callout = new Callout();
        callout.setRegionName(calloutDTO.regionName());
        callout.setSuperRegionName(calloutDTO.superRegionName());
        callout.setMap(map);
        return callout;
    }
}
