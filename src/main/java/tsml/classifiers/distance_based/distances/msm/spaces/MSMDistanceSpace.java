package tsml.classifiers.distance_based.distances.msm.spaces;

import tsml.classifiers.distance_based.distances.DistanceMeasure;
import tsml.classifiers.distance_based.distances.msm.MSMDistance;
import tsml.classifiers.distance_based.utils.collections.params.ParamSpace;
import tsml.classifiers.distance_based.utils.collections.params.ParamSpaceBuilder;
import tsml.data_containers.TimeSeriesInstances;

import static tsml.classifiers.distance_based.utils.collections.CollectionUtils.newArrayList;

public class MSMDistanceSpace implements ParamSpaceBuilder {
    @Override public ParamSpace build(final TimeSeriesInstances data) {
        return new ParamSpace().add(DistanceMeasure.DISTANCE_MEASURE_FLAG, newArrayList(new MSMDistance()), new MSMDistanceParams().build(data));
    }
}
