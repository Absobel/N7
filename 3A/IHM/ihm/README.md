Here are some useful cmake commands for the compilation and to generate projects for some IDEs.

## Compile, run and package
```bash
cmake -S . -B build -DCMAKE_BUILD_TYPE=Debug
make -j8 -C build
```

```bash
cmake -S . -B build -DCMAKE_BUILD_TYPE=Release
make -j8 -C build
make -j8 -C build package
```

## Generate Xcode project
```bash
cmake -S . -B builds/xcode -DCMAKE_BUILD_TYPE=Debug -G "Xcode"
```

## Generate Visual Studio project
```bash
cmake -S . -B builds/visualstudio -DCMAKE_BUILD_TYPE=Debug -G "Visual Studio 10"
```

