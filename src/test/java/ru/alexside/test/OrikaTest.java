package ru.alexside.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.alexside.dto.GpoHeaderFull;
import ru.alexside.mapper.JPAToDTOConverter;
import ru.alexside.model.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 25.03.2018.
 */
public class OrikaTest {

    private GpoHeader origin;

    @Before
    public void before() {
        origin = new GpoHeader();
        origin.setId(25L);
        List<RpoHeader> rpoHeaders = new ArrayList<>();
        RpoHeader rpoHeader = new RpoHeader();
        rpoHeader.setId(1L);
        rpoHeader.setProNumber("100080100204");
        rpoHeader.setGpoHeader(origin);
        rpoHeader.setZip5From("90001");
        rpoHeader.setZip5To("90025");

        String stopGroupId = UUID.randomUUID().toString();
        rpoHeader.setStopGroupId(stopGroupId);
        String costGroupId = UUID.randomUUID().toString();
        rpoHeader.setCostGroupId(costGroupId);
        String claimGroupId = UUID.randomUUID().toString();
        rpoHeader.setClaimGroupId(claimGroupId);
        String logGroupId = UUID.randomUUID().toString();
        rpoHeader.setLogGroupId(logGroupId);

        State state = new State();
        state.setId(11L);
        state.setCode(StateCodes.GRAY_PO_NEW);
        state.setInitialState(true);
        state.setStateName("CREATION");
        state.setStateType(PoType.GRAY_PO);
        rpoHeader.setState(state);

        Route route = new Route();
        route.setId(1001L);
        route.setPoints("23,443,145,567,2,1,56");
        rpoHeader.setRoute(route);

        List<Cost> costs = new ArrayList<>();

        Cost cost1 = new Cost();
        cost1.setId(100L);
        cost1.setCostType(CostType.CARGGO_FEE);
        cost1.setGpoServiceId(11L);
        cost1.setCostGroupId(costGroupId);
        cost1.setPenaltyCost(new BigDecimal("25.75"));
        cost1.setReceivedAmount(5L);
        cost1.setRateCost(new BigDecimal("5.99"));
        cost1.setTotalCost(new BigDecimal("125.00"));
        costs.add(cost1);

        Cost cost2 = new Cost();
        cost2.setId(101L);
        cost2.setCostType(CostType.CARGGO_FEE);
        cost2.setGpoServiceId(12L);
        cost2.setCostGroupId(costGroupId);
        cost2.setPenaltyCost(new BigDecimal("23.75"));
        cost2.setReceivedAmount(5L);
        cost2.setRateCost(new BigDecimal("12.99"));
        cost2.setTotalCost(new BigDecimal("175.00"));
        costs.add(cost2);

        rpoHeader.setCosts(costs);

        List<Claim> claims = new ArrayList<>();
        Claim claim1 = new Claim();
        claim1.setId(103L);
        claim1.setClaimGroupId(121L);
        claim1.setClaimStatus("OK");
        claim1.setCreatedDate(LocalDateTime.now());
        claim1.setDescription("...");
        claims.add(claim1);

        Claim claim2 = new Claim();
        claim2.setId(104L);
        claim2.setClaimGroupId(121L);
        claim2.setClaimStatus("ERROR");
        claim2.setCreatedDate(LocalDateTime.now());
        claim2.setDescription("...");
        claims.add(claim2);

        rpoHeader.setClaims(claims);
        rpoHeader.setPostTime(LocalDateTime.now().plusDays(3));
        rpoHeader.setType(RpoType.TRANSPORTATION);
        rpoHeader.setTotalCost(new BigDecimal("425.00"));
        rpoHeader.setFuelCost(new BigDecimal("123.00"));
        rpoHeader.setLineHaulCost(new BigDecimal("56.00"));
        rpoHeader.setTeamDriveCost(new BigDecimal("132.00"));

        List<Service> services = new ArrayList<>();
        Service service = new Service();
        service.setId(1002L);
        service.setGpoHeader(origin);
        service.setTotalCost(new BigDecimal("44.50"));
        service.setRateCost(new BigDecimal("15.99"));
        service.setRpoHeaderId(1L);
        service.setServiceUuid(UUID.randomUUID());
        service.setStopPoint(null);
        services.add(service);

        rpoHeader.setServices(services);

        rpoHeaders.add(rpoHeader);

        origin.setRpoHeaders(rpoHeaders);
        Contact shipper = new Contact();
        shipper.setId(1L);
        shipper.setCompanyName("FASTRANSIT");
        shipper.setDescription("...");
        shipper.setName("FT");
        shipper.setType("CUSTOM");
        shipper.setDetails(asList("+7(422)6440032", "testft@gmail.com"));
        origin.setShipper(shipper);
        origin.setZip5From("90001");
        origin.setZip5To("90025");

        List<Stop> stops = new ArrayList<>();
        Stop stop = new Stop();
        stop.setId(1L);
        stop.setAddress("NY, 12 avenue, 5");
        stop.setLatitude(34.2d);
        stop.setLongitude(10.2d);
        stop.setStopGroupId(stopGroupId);
        stop.setLayoverTime(Duration.ZERO);
        stop.setContacts(asList(shipper));
        stop.setStopOrder(66);
        stop.setStopType(2);
        stop.setWaitTime(Duration.ofDays(7));
        stops.add(stop);
        origin.setStops(stops);
        origin.setServices(services);
        origin.setContractId(1025L);
        origin.setTotalDistance(new BigDecimal("355.8"));
        origin.setTotalTime(320L);
        origin.setTotalWeight(211);
        origin.setWeightUom(204d);
        origin.setTotalLength(203);
        origin.setTotalHeight(56);
        origin.setPoType(PoType.GRAY_PO);

    }


    @Test
    public void test() {
        GpoHeaderFull dto = JPAToDTOConverter.FACADE.map(origin, GpoHeaderFull.class);
        Assert.assertNotNull(dto);
        GpoHeader reversed = JPAToDTOConverter.FACADE.map(dto, GpoHeader.class);
        Assert.assertEquals(origin.getRpoHeaders().iterator().next(), reversed.getRpoHeaders().iterator().next());
    }
}
