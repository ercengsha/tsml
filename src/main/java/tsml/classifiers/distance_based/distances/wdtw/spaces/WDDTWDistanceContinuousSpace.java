package tsml.classifiers.distance_based.distances.wdtw.spaces;

import tsml.classifiers.distance_based.distances.DistanceMeasure;
import tsml.classifiers.distance_based.distances.transformed.BaseTransformDistanceMeasure;
import tsml.classifiers.distance_based.distances.transformed.TransformDistanceMeasure;
import tsml.classifiers.distance_based.distances.wdtw.WDTWDistance;
import tsml.classifiers.distance_based.utils.collections.params.ParamSpace;
import tsml.classifiers.distance_based.utils.collections.params.ParamSpaceBuilder;
import tsml.data_containers.TimeSeriesInstances;
import tsml.transformers.Derivative;

import static tsml.classifiers.distance_based.distances.wdtw.spaces.WDDTWDistanceSpace.newWDDTWDistance;
import static tsml.classifiers.distance_based.utils.collections.CollectionUtils.newArrayList;

public class WDDTWDistanceContinuousSpace implements ParamSpaceBuilder {

    @Override public ParamSpace build(final TimeSeriesInstances data) {
        return new ParamSpace().add(DistanceMeasure.DISTANCE_MEASURE_FLAG, newArrayList(newWDDTWDistance()),
                new WDTWDistanceContinuousParams().build(data));
    }
}
