# Iris-Detection
Java desktop application for detection and localization of iris and pupil on an image.

Application allows to open image file from user's directories, and later to save processed image.

Pupil detection has accuracy around 93%. It is performed by following method:
* Thresholding image by value 50
* Performing combination of morphological operations
* Computing horizontal and vertical projections
* Finding indexes of maximal values of projections, and approximating radius at region around maximum
* Drawing circle based on obtained center and radius

Iris detection has accuracy around 75%. It is implemented as follows:
* Adaptive thresholding extracts iris area on image
* Combination of erosion and dilation removes unnecessary details
* Horizontal, vertical and diagonal projections are computed
* Center of iris is computed by maximums of horizontal and vertical projections
* Radius is computed based on all 4 projections
* Circle approximating iris is drawn based on obtained center and radius
