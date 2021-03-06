package common.simulation.scenarios;

import common.configuration.JRConfig;
import se.sics.kompics.p2p.experiment.dsl.SimulationScenario;


@SuppressWarnings("serial")
public class Scenario1 extends Scenario
{
    private static final int MINUTE = 60000;
    
    private static SimulationScenario scenario = new SimulationScenario()
    {
        {
            StochasticProcess process1 = new StochasticProcess()
            {
                {
                    eventInterArrivalTime(constant(100));
                    raise(1, Operations.peerJoin(5), uniform(13));
                }
            };
            StochasticProcess process2 = new StochasticProcess()
            {
                {
                    eventInterArrivalTime(constant(1));
                    raise(JRConfig.NUMBER_OF_NODES - 1, Operations.peerJoin(5), uniform(13));
                }
            };
            StochasticProcess process3 = new StochasticProcess()
            {
                {
                    eventInterArrivalTime(constant(JRConfig.NEW_ENTRY_DELAY));
                    raise(JRConfig.NUMBER_OF_INDEX_ENTRIES, Operations.addIndexEntry(), uniform(13));
                }
            };
            StochasticProcess process4 = new StochasticProcess()
            {
                {
                    eventInterArrivalTime(constant(100));
                    raise(1, Operations.killLeader(), uniform(13));
                }
            };

            process1.start();
            process2.startAfterTerminationOf(2000, process1);
            process3.startAfterTerminationOf(2 * MINUTE, process2);
//            process4.startAfterStartOf(10000, process3);
        }
    };

    public Scenario1() {
        super(scenario);
    }
}
